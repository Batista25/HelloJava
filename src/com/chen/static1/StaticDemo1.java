package com.chen.static1;

public class StaticDemo1 {
	public static void main(String[] args) { 
	    Test2 t=new Test2(); 
	    t.f1();    
	    t.f2(); //调用从父类继承过来的final方法 
	    t.f3(); //调用从父类继承过来的方法 
	    //t.f4(); //调用失败，无法从父类继承获得 
	}		
}
