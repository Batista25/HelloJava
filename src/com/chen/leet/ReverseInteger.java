/**
 * 
 */
package com.chen.leet;

/**
 * 整数翻转
 * @author ChenShi
 * @date   2017年8月14日下午4:58:09
 */
public class ReverseInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x = 1;
		System.out.println(reverse(x));
		

	}
	
	public static int reverse1(int x) {
		int result = 0;
        int newResult = 0;
		while (x != 0) {
			newResult = result*10 + x%10;
            if(newResult/10 != result) return 0;
			result =newResult;
			x /=10;
			
		}
		return result;		
	}
	
	public static int reverse(int x) {
        long rev= 0;
        while( x != 0){
            rev= rev*10 + x % 10;
            x= x/10;
            if( rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
                return 0;
        }
        return (int) rev;
    }

}
