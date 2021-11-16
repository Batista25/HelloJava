package cn.chenshi.helloJava.thread.ABC;

/**
 * @author ChenShi
 * @date 2021/11/1 下午4:57
 */
public class SynchronizedImp {
    private static int count  = 0;
    private static  Object obj  = new Object();
    public static void main(String[] args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                int num = 0;
                while(num < 10){
                    synchronized (obj){
                        if (count % 3 == 0){
                            System.out.print(Thread.currentThread().getName());
                            count++;
                            num++;
                            obj.notifyAll();
                        }else {
                            try {
                                obj.wait();
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
                int num = 0;
                while(num < 10){
                    synchronized (obj){
                        if (count % 3 == 1){
                            System.out.print(Thread.currentThread().getName());
                            count++;
                            num++;
                            obj.notifyAll();
                        }else {
                            try {
                                obj.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }


            }
        },"B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int num = 0;
                while(num < 10){
                    synchronized (obj){
                        if (count % 3 == 2){
                            System.out.print(Thread.currentThread().getName());
                            count++;
                            num++;
                            obj.notifyAll();

                        }else {
                            try {
                                obj.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }


            }
        },"C").start();

    }
}
