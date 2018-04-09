package com.chen.reflect;

public class ClassDemo1 {

	public static void main(String[] args) {
		//Foo的实例对象
		Foo foo = new Foo();

		//Foo也是一个实例对象，这个实例对象有三种表示方式
		//第一种，任何一个类都有一个隐含的静态成员变量class
		Class c1 = Foo.class;

		//第二种，已知该类的对象，通过getClass()方法
		Class c2 = foo.getClass();
		
		//每个类只有一个实例对象
		System.out.println(c1==c2);

		//第三种
		Class c3 = null;
		try {
			c3 = Class.forName("com.chen.reflect.Foo");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(c3==c2);
		
		//可以通过类的类类型创建该类的实例，即通过c1 or c2 or c3创建Foo的实例
		try {
			Foo foo1 = (Foo)c1.newInstance();
			foo1.print();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
}
class Foo{
	void print(){
		System.out.println("Foo");
	}
	
}
