package cn.chenshi.helloJava.thread.ProducerAndConsumer;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ChenShi
 * @date 2021/11/1 下午6:10
 */
public class ReentrantLockAndConditionImp<T> {
    final private LinkedList<T> list = new LinkedList<>();
    final private int MAX = 10;
    private int count = 0;

    private Lock lock = new ReentrantLock(); //Lock接口 java.util.concurrent.locks.Lock  ReentrantLock重入锁
    private Condition producer = lock.newCondition(); //Condition接口 java.util.concurrent.locks.Condition
    private Condition consumer = lock.newCondition();

    public /*synchronized*/ void put(T t) {
        try{
            lock.lock();//

            while (list.size() == MAX) {  //想想为什么用while而不是if   while会再次检查！
                try {
                    //this.wait(); //effective java一书中说wait 99.9%和 while一起使用,wait释放锁
                    producer.await();//
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(t);
            ++count;
    //		this.notifyAll(); //通知消费者线程进行消费
            consumer.signalAll(); //精确叫醒消费者线程
        }finally {
            lock.unlock();
        }

    }

    public /*synchronized*/ T get() {
        T t = null;
        try{
            lock.lock();//

            while (list.size() == 0) {
                try {
    //				this.wait();
                    consumer.await();//
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            t = list.removeFirst(); //Removes and returns the first element from this list.
            count --;
    //		this.notifyAll();
            producer.signalAll(); //精确指定消费者线程消费
            return t;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockAndConditionImp<String> c = new ReentrantLockAndConditionImp<>();
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
        for (int i = 0; i < 2; i++) { //2个生产者线程
            new Thread(()->{
                for (int j = 0; j < 8 ;j++) {
                    c.put(Thread.currentThread().getName()+" "+j );
                    System.out.println("生产者:"+Thread.currentThread().getName()+" "+j );
                }
            },"product"+i) .start();
        }
    }

}
