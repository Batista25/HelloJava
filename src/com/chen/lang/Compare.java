/**
 * 
 */
package com.chen.lang;

/**
 * @author ChenShi
 * @date   2018年4月12日上午12:19:24
 */
public class Compare {
	
	public static void main(String[] args) {
		int a1 = 10;
		Long a2 = 127l;
		Long a3 = new Long(127);
//		System.out.println("int:");
//		System.out.println(a1==a2);
//		System.out.println(a1==a3);
		System.out.println(a2==a3);
//		System.out.println(Integer.compare(a1, a3.intValue()));
		
		long l1 = 100;
		Long l2 = 100l;
		Long l3 = new Long(100);
//		System.out.println("Long:");
//		System.out.println(l1==l2);
//		System.out.println(l1==l3);
//		System.out.println(l2==l3);
//		System.out.println(l2.compareTo(l3));
		
		Byte num1 = 127;
		Byte num2 = 127;
		byte num3 = 127;
//		System.out.println(num1 == num2);
//		System.out.println(num1 == num3);
//		System.out.println(num2.longValue() == num3);
		
//		String aString = "123";
//		String bString = "123";
//		String cString = new String("123");
//		System.out.println(aString == bString);
//		System.out.println(aString == cString);
		
		
		
	}
	
	
	
	

}
