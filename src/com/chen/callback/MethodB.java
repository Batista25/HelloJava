/**
 * 
 */
package com.chen.callback;

/**
 * @author ChenShi
 * @date   2018��3��23������2:16:09
 */
public class MethodB {
	public double getTime(CallBackInterface callBack) {
			    long start = System.currentTimeMillis();
			    callBack.exectueMethod();
			    long end = System.currentTimeMillis();
			    System.out.println("cost time=" + (end - start));
			    return end - start;
			  }
}
