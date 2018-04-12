package com.chen.static1;

public class Test2 extends Test1 {
	static{
		System.out.println("Test2静态代码区!");
	}
	
	static int a = 10;
	
	public Test2() {
		System.out.println("Test2构造方法！");
	}
	public void f1(){     
	    System.out.println("Test1父类方法f1被覆盖!"); 
	} 	
}
