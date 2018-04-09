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
             * (��Ϣ2S,�����߳�)
             * ����֤��ǰ�̶߳���Ļ�����ռ��ʱ, 
             * �Ƿ񱻿��Է�������ͬ������� 
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