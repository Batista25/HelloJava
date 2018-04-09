/**
 * 
 */
package com.chen.leet;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * @author ChenShi
 * @date   2017年8月14日上午11:27:24
 */
public class MaximumSubarray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		int max = maxSubArray(nums);
		System.out.println(max);

	}
	/**
	 * 假设所求子串的结尾为nums[i]，
	 * 从i=0开始，向后依次遍历，得到以nums[i]结尾的当前最大子串之和currMax
	 * 每次遍历之后更新字串最大子串之和max
	 * @param nums
	 * @return
	 */
	public static int maxSubArray(int[] nums) {
	    int currMax=nums[0],max=nums[0];
	    for(int i=1;i<nums.length;i++){
	    	//只有当nums[i]之前的序列之和为正数时才继续向后累加
	        currMax=Math.max(currMax+nums[i],nums[i]);
	        max=Math.max(max,currMax);
	    }
	    return max;
	}
	
	/**
	 * 
	 * @param A
	 * @return
	 */

	public int maxSubArry1(int[] A) {
		int maxSum = 0 , thisSum = 0;
		for (int i = 0; i < A.length; i++) {
			thisSum += A[i];
			if (thisSum > maxSum) {
				maxSum = thisSum;
			}else if (thisSum < 0) {//前置子串必为正数
				thisSum = 0;
			}
		}
		return maxSum;		
	}
	
	/**
	 * 将求整个数组的最大子串问题，分解为求以第i个元素结尾的子串的最大子串之和
	 * 通过求maxSubArray(A, i)，逐步推导至求maxSubArray(A, n)
	 * maxSubArray(A, i) = maxSubArray(A, i - 1) > 0 ? maxSubArray(A, i - 1) : 0 + A[i]; 
	 * @param A
	 * @return
	 */
	public int maxSubArray2(int[] A) {
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];
        
        for(int i = 1; i < n; i++){
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        
        return max;
}

}
