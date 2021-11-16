package cn.chenshi.helloJava.thread.ProducerAndConsumer;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * @author ChenShi
 * @date 2021/11/1 下午6:08
 */
public class SynchronizeImp<T> {
    final private LinkedList<T> list = new LinkedList<>();
    final private int MAX = 10;
    private int count = 0;

    public synchronized void put(T t) {
        while (list.size() == MAX) {  //想想为什么用while而不是if   while会再次检查！
            try {
                this.wait(); //effective java一书中说wait 99.9%和 while一起使用,wait释放锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(t);
        ++count;
        this.notifyAll(); //通知消费者线程进行消费
    }

    public synchronized T get() {
        T t = null;
        while (list.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t = list.removeFirst(); //Removes and returns the first element from this list.
        count --;
        this.notifyAll();
        return t;
    }

    public static void main(String[] args) {
        SynchronizeImp<String> c = new SynchronizeImp<>();
        //启动消费者线程
        for (int i = 0; i < 10; i++) { //10个消费者线程
            new Thread(()->{
                for (int j = 0; j < 4; j++) {
                    System.out.println(Thread.currentThread().getName()+"-->"+c.get());
                }
            },"consumer"+i) .start();
        }

        System.out.println("等待2秒生产-开始");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("等待2秒生产-结束");

        //启动生产者线程
        for (int i = 0; i < 5; i++) { //2个生产者线程
            new Thread(()->{
                for (int j = 0; j < 8 ;j++) {
                    c.put(Thread.currentThread().getName()+" "+j );
                    System.out.println("生产者:"+Thread.currentThread().getName()+" "+j );
                }
            },"product"+i) .start();
        }
    }

}
