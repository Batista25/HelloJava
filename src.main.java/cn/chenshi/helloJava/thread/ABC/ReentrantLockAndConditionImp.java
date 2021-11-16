package cn.chenshi.helloJava.thread.ABC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ChenShi
 * @date 2021/11/1 下午5:20
 */
public class ReentrantLockAndConditionImp {
    public static int count = 0;
    public static Lock lock = new ReentrantLock();
    public static Condition conditionA = lock.newCondition();
    public static Condition conditionB = lock.newCondition();
    public static Condition conditionC = lock.newCondition();

    public static void main(String[] args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                int num = 0;
                while (num < 5){
                    try{
                        lock.lock();
                        if (count%3 == 0){
                            System.out.print(Thread.currentThread().getName());
                            count++;
                            num++;
                            conditionB.signal();
                        }else {
                            conditionA.await();
                        }
                    }catch (Exception e){
                        e.printStackTrace();
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
                while (num < 5){
                    try{
                        lock.lock();
                        if (count%3 == 1){
                            System.out.print(Thread.currentThread().getName());
                            count++;
                            num++;
                            conditionC.signal();

                        }else {
                            conditionB.await();
                        }
                    }catch (Exception e){
                        e.printStackTrace();
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
                while (num < 5){
                    try{
                        lock.lock();
                        if (count%3 == 2){
                            System.out.print(Thread.currentThread().getName());
                            count++;
                            num++;
                            conditionA.signal();
                        }else {
                            conditionC.await();
                        }

                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                }
            }
        },"C").start();
    }
}
