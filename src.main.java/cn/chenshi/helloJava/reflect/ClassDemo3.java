package cn.chenshi.helloJava.reflect;

public class ClassDemo3 {

	public static void main(String[] args) {
		String long1 = "";
		ClassUtil.printClassMethodMessage(long1);
		System.out.println("**************");
		ClassUtil.printFieldMessage(long1);
		System.out.println("**************");
		ClassUtil.printConMessage(long1);
		

	}

}
