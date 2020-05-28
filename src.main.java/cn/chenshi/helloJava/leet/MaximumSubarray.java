/**
 * 
 */
package cn.chenshi.helloJava.leet;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * @author ChenShi
 * @date   2017��8��14������11:27:24
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
	 * ���������Ӵ��Ľ�βΪnums[i]��
	 * ��i=0��ʼ��������α������õ���nums[i]��β�ĵ�ǰ����Ӵ�֮��currMax
	 * ÿ�α���֮������ִ�����Ӵ�֮��max
	 * @param nums
	 * @return
	 */
	public static int maxSubArray(int[] nums) {
	    int currMax=nums[0],max=nums[0];
	    for(int i=1;i<nums.length;i++){
	    	//ֻ�е�nums[i]֮ǰ������֮��Ϊ����ʱ�ż�������ۼ�
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
			}else if (thisSum < 0) {//ǰ���Ӵ���Ϊ����
				thisSum = 0;
			}
		}
		return maxSum;		
	}
	
	/**
	 * �����������������Ӵ����⣬�ֽ�Ϊ���Ե�i��Ԫ�ؽ�β���Ӵ�������Ӵ�֮��
	 * ͨ����maxSubArray(A, i)�����Ƶ�����maxSubArray(A, n)
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
