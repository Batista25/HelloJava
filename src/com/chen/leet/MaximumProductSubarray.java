/**
 * 
 */
package com.chen.leet;

/**
 * @author ChenShi
 * @date   2017年8月14日下午3:22:17
 */
public class MaximumProductSubarray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {-4,-3,-2};
		System.out.println(maxProduct(nums));

	}
	/**
	 * 
	 * @param nums
	 * @return
	 */
    public static int maxProduct(int[] nums) {
        int max = nums[0],min=nums[0],result=nums[0];
        for(int i = 1;i< nums.length;i++){
            int temp = max;
            max = Math.max(Math.max(max * nums[i],min * nums[i]),nums[i]);
            min = Math.min(Math.min(temp * nums[i],min * nums[i]),nums[i]);
            if(result < max){
                result = max;
            } 
        }
          
         return result;
    }

}
