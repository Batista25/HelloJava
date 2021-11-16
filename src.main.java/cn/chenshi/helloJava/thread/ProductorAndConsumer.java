package cn.chenshi.helloJava.thread;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ChenShi
 * @date 2021/10/29 下午3:50
 */
public class ProductorAndConsumer {

    static volatile int count = 0;
    public static void main(String[] args){
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(100);

        new Thread(()->{
            while(true){
                synchronized (queue){
                    while (count >= 10){
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产: " + count);
                    queue.add(count);
                    queue.notify();
                }


            }
        },"生产者").start();
        new Thread(()->{
            while(true){
                synchronized (queue){
                    while (count <= 0){
                        try {
                            queue.notify();
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int c = queue.poll();
                    System.out.println(Thread.currentThread().getName() + "消费: " + c);
                    count--;
                }


            }
        },"消费者").start();
    }
}
