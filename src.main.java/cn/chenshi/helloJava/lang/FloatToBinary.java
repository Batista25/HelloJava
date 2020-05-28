/**
 * 
 */
package cn.chenshi.helloJava.lang;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author ChenShi
 * @date   2017��9��22������2:27:08
 */
public class FloatToBinary {

	static Scanner scan = new Scanner(System.in);

    //������ĸ������ֳ��������ֺ�С������
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

//����������ת�ɶ�����
static String intToStr(int n){
    if(n==0) return "";
    int a = n % 2;
    int b = n / 2;
    return intToStr(b) + a;
}

//��С������ת�ɶ�����
static String dToStr(double d){
    if(d-(int)d<0.01) return "" + (int)d;
    int n = (int)(d * 2);
    double a = d * 2 - n;
    return "" + n + dToStr(a);
}

//����������ת��double
static int sToInt(String s){
    if(s.length()==1) return s.charAt(0)-'0';
    return sToInt(s.substring(0,s.length()-1)) * 2
            + (s.charAt(s.length()-1)-'0');
}

//��С������ת��double
static double sToDou(String s){
    if(s.length()==1) return (s.charAt(0)-'0')/2.0;
    return (s.charAt(0)-'0')/2.0 + sToDou(s.substring(1))/2.0;
}

//��������ַ����ֳ���������s1��С������s2
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
    System.out.println("������һ�������ƴ���");
    String s = scan.nextLine().trim();
    System.out.println(strToDou(s));
    System.out.println("������һ����������");
    String s2 = scan.nextLine().trim();
    System.out.println(douToStr(s2));
    
    
}

}
