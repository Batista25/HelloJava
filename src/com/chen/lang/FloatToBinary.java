/**
 * 
 */
package com.chen.lang;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author ChenShi
 * @date   2017年9月22日下午2:27:08
 */
public class FloatToBinary {

	static Scanner scan = new Scanner(System.in);

    //把输入的浮点数分成整数部分和小数部分
static String douToStr(String s){
    int n = s.indexOf(".");
    if(n<0){
        s += ".0";
        n = s.indexOf(".");
    }
    String s1 = s.substring(0,n);
    String s2 = "0" + s.substring(n);
    
    String s3 = intToStr(Integer.parseInt(s1));
    String s4 = dToStr(Double.parseDouble(s2));
    return  (s3.length()==0? 0 : s3) + "." + s4;
}

//把整数部分转成二进制
static String intToStr(int n){
    if(n==0) return "";
    int a = n % 2;
    int b = n / 2;
    return intToStr(b) + a;
}

//把小数部分转成二进制
static String dToStr(double d){
    if(d-(int)d<0.01) return "" + (int)d;
    int n = (int)(d * 2);
    double a = d * 2 - n;
    return "" + n + dToStr(a);
}

//把整数部分转成double
static int sToInt(String s){
    if(s.length()==1) return s.charAt(0)-'0';
    return sToInt(s.substring(0,s.length()-1)) * 2
            + (s.charAt(s.length()-1)-'0');
}

//把小数部分转成double
static double sToDou(String s){
    if(s.length()==1) return (s.charAt(0)-'0')/2.0;
    return (s.charAt(0)-'0')/2.0 + sToDou(s.substring(1))/2.0;
}

//把输入的字符串分成整数部分s1和小数部分s2
static double strToDou(String s){
    int n = s.indexOf(".");
    if(n<0){
        s += ".0";
        n = s.indexOf(".");
    }
    String s1 = s.substring(0,n);
    String s2 = s.substring(n+1);
    return sToInt(s1) + sToDou(s2);
}

public static void main(String[] args) {
    System.out.println("请输入一个二进制串：");
    String s = scan.nextLine().trim();
    System.out.println(strToDou(s));
    System.out.println("请输入一个浮点数：");
    String s2 = scan.nextLine().trim();
    System.out.println(douToStr(s2));
    
    
}

}
