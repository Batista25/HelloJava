package cn.chenshi.helloJava.thread;

public class RunnableDemo implements Runnable {
	private Thread t;
	private String threadName;

	RunnableDemo(String name) {
		threadName = name;
		System.out.println("Creating " + threadName);
	}

	public void run() {
		System.out.println("Running " + threadName);
		try {
			for (int i = 4; i > 0; i--) {
				System.out.println("Thread: " + threadName + ", " + i);
				// 让线程睡眠一会
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			System.out.println("Thread " + threadName + " interrupted.");
		}
		System.out.println("Thread " + threadName + " exiting.");
	}

	
	public static void main(String args[]) {
		RunnableDemo R1 = new RunnableDemo("Thread-1");
		Thread t1 = new Thread(R1);	//通过实现Runnable接口的实例创建线程1
		t1.start();

		RunnableDemo R2 = new RunnableDemo("Thread-2");
		Thread t2 = new Thread(R2);
		t2.start();
	}
}
