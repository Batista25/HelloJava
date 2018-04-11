package com.chen.thread;

public class Test implements Runnable {  
    int number = 10;  
  
    public void firstMethod() throws Exception {  
        synchronized (this) {
            number += 100;  
            System.out.println("firstMethod " + number);  
        }  
    }  
  
    public void secondMethod() throws Exception {  
        synchronized (this) {  
            /** 
             * (休息2S,阻塞线程)
             * 以验证当前线程对象的机锁被占用时, 
             * 是否被可以访问其他同步代码块 
             */  
            System.out.println("secondMethod begin " + number);  
            //Thread.sleep(2000);  
            this.wait();
            number *= 200;  
            System.out.println("secondMethod " + number);  
        }  
    }  
  
    @Override  
    public void run() {  
        try {  
            firstMethod();  
        } catch (Exception e) {  
            e.printStackTrace();    
        }  
    }   
  
    public static void main(String[] args) throws Exception {  
        Test threadTest = new Test();  
        Thread thread = new Thread(threadTest);  
        thread.start();  
        threadTest.secondMethod();
        thread.notifyAll();
        
    }  
} 