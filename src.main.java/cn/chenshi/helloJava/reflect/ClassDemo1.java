package cn.chenshi.helloJava.reflect;

public class ClassDemo1 {

	public static void main(String[] args) {
		//Foo��ʵ������
		Foo foo = new Foo();

		//FooҲ��һ��ʵ���������ʵ�����������ֱ�ʾ��ʽ
		//��һ�֣��κ�һ���඼��һ�������ľ�̬��Ա����class
		Class c1 = Foo.class;

		//�ڶ��֣���֪����Ķ���ͨ��getClass()����
		Class c2 = foo.getClass();
		
		//ÿ����ֻ��һ��ʵ������
		System.out.println(c1==c2);

		//������
		Class c3 = null;
		try {
			c3 = Class.forName("com.chen.reflect.Foo");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(c3==c2);
		
		//����ͨ����������ʹ��������ʵ������ͨ��c1 or c2 or c3����Foo��ʵ��
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
