package com.chen.static1;

public class Test1 {
	public void f1() { 
	    System.out.println("f1"); 
	} 
	//无法被子类覆盖的方法 
	public static void f2() { 
	    System.out.println("f2"); 
	} 
	public void f3() { 
	    System.out.println("f3"); 
	} 
	private void f4() { 
	    System.out.println("f4"); 
	} 
	
	public static class A{
		public static void f7() { 
		    System.out.println("f2"); 
		} 
	}
}
