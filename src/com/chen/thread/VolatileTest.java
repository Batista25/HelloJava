/**
 * 
 */
package com.chen.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ChenShi
 * @date   2018年4月11日下午6:05:26
 */
public class VolatileTest extends Thread {
	public volatile static long  n = 0;
//	static AtomicInteger n = new AtomicInteger(0);
	
//	public static void f(){
//		n++;
//	}
	
	@Override
	public void run() {
		for(int i = 0;i<1000;i++){			
				count();
//			try {
//				this.sleep(10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		
	};
	
	public void count() {
		n++;
//		n.getAndIncrement();
	}
	
	public static void main(String[] args){
		ThreadPoolExecutor executor = new ThreadPoolExecutor(// 自定义一个线程池  
                10, // coreSize  
                20, // maxSize  
                60, // 60s  
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(3) );
		for(int i=0;i<10;i++){
			VolatileTest test2 = new VolatileTest();
			executor.execute(test2);
		}
		executor.shutdown();
//		executor.shutdownNow();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(n);
	}
}
