package cn.chenshi.helloJava.thread.ABC;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ChenShi
 * @date 2021/11/1 下午5:08
 */
public class ReentrantLockImp {
    public static Lock lock = new ReentrantLock();
    public static int count = 0;
    public static void main(String[] args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                int num = 0;
                while(num < 2){
                    try{
                        lock.lock();
                        if (count % 3 == 0){
                            System.out.print(Thread.currentThread().getName());
                            count++;
                            num ++;
                        }
                    }finally {
                        lock.unlock();
                    }

                }

            }
        },"A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int num = 0;
                while(num < 2){
                    try{
                        lock.lock();
                        if (count % 3 == 1){
                            System.out.print(Thread.currentThread().getName());
                            count++;
                            num ++;
                        }
                    }finally {
                        lock.unlock();
                    }

                }

            }
        },"B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int num = 0;
                while(num < 2){
                    try{
                        lock.lock();
                        if (count % 3 == 2){
                            System.out.print(Thread.currentThread().getName());
                            count++;
                            num ++;
                        }
                    }finally {
                        lock.unlock();
                    }

                }

            }
        },"C").start();
    }
}
