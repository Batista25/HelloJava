/**
 * 
 */
package com.chen.callback;

/**
 * @author ChenShi
 * @date   2018��3��23������2:19:09
 */
public class MethodA {
	
	 public static void main(String args[]){
			    MethodB b=new MethodB();
			    //����ֵdֻ��MethodB�йأ��ͽӿ��з����ķ���ֵ�޹�
			    double d=b.getTime(new CallBackInterface()
			 {
			        
			      //����ʵ�������Ķ���Ľӿ�
			      public void exectueMethod()
			 {
			    	  MethodA methodA =  new MethodA();
			    	  methodA.testMethod();
			      }
			        
			      @Override
			      public void doSome()
			 {
			          
			      }
			    });
			    System.out.println("d="+d);
			  }
			    
			  public void testMethod(){
			    for(int i=0;i<10000;i++){
			      System.out.print("");
			    }
			    System.out.println("testMethod");
			  }

}
