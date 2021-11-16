package cn.chenshi.helloJava.thread;

/**
 * @author ChenShi
 * @date 2021/10/29 下午3:13
 */
public class CrossPrint {
    private static int i = 1;
    static Object lock = new Object();

    public static void main(String[] args){
        /**
         * synchroni
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (i<= 100){
                    synchronized (lock){
                        if(i %2 == 1){
                            System.out.println(Thread.currentThread().getName() + i);
                            i++;
                            lock.notifyAll();
                        }else {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        },"A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (i<= 100){
                    synchronized (lock){
                        if(i %2 == 0){
                            System.out.println(Thread.currentThread().getName() + i);
                            i++;
                            lock.notifyAll();
                        }else {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        },"B").start();
    }
}
