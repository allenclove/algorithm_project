package cn.alenc.dynamicprogram;

/**
 * 找出连续子序列的最大和 = 9
 * [3,-4,2,-1,2,6,-5,4]
 *
 * 这题的难点就是求出动态转移方程, 例如索引是i， 数组是nums
 * 要求连续子序列最大和， 比如是dp[i]， 那么和前一个最大和的关系就是dp[i] = dp[i-1] + nums[i]
 * 那么当dp[i-1]<0, dp[i]肯定是变小的， 所以当dp[i-1]<0， 我们就不加dp[i-1]，也就是dp[i] = nums[i]   //这里非常难想
 * 那么我们连续加出来的最大值就存储到当前数组的对应位置， 最后再取数组中最大的和， 也就是该数组的连续子序列的最大和
 *           /-- dp[i] = dp[i-1] + nums[i],  dp[i-1]>0
 * 状态转移方程：
 *           \-- dp[i] = nums[i],  dp[i-1]<0
 */
public class 连续子序列的最大和 {

    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {3, -4, 2, -1, 2, 6, -5, 4};
        System.out.println(maxSubArray(nums));
    }
}
