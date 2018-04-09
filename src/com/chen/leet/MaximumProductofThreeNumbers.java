/**
 * 
 */
package com.chen.leet;

import java.util.Arrays;

/**
 * �������������������˻������ֵ����ֵȡֵ��Χ[-1000,1000]
 * @author ChenShi
 * @date   2017��8��14������4:30:10
 */
public class MaximumProductofThreeNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {-10,-15,5,98,6,14};
		System.out.println(maximumProduct1(nums));
		System.out.println(maxinumProduct2(nums));

	}
	/**
	 * ������ҵ���С��������������������
	 * @param nums
	 * @return
	 */
	public static int maximumProduct1(int[] nums) {
		Arrays.sort(nums);
		return Math.max(nums[0]*nums[1]*nums[nums.length-1], nums[nums.length-3]*nums[nums.length-2]*nums[nums.length-1]);		 
	}
	/**
	 * ֻ�����һ���ҳ���С��������������������
	 * @param nums
	 * @return
	 */
	public static int maxinumProduct2(int[] nums) {
		 int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
	     int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
	     for (int n: nums) {
			if (n< min1) {
				min2 = min1;
				min1 = n;
			} else if (n < min2) {
				min2=n;
			}
			if (n > max1) {
				max3=max2;
				max2=max1;
				max1 = n;
			} else if (n > max2) {
				max3 = max2;
				max2 = n;
			}else if (n > max3) {
				max3 =n;
			}
		}
		return Math.max(min1*min2*max1, max1*max2*max3);
	}

}
