package cn.alenc.dynamicprogram;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName 打家劫舍
 * @Description
 * @Author ALLENC
 * @Date 2021/7/28 23:14
 * <p>
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 *  
 * <p>
 * 示例 1：
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * <p>
 * 示例 2：
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * <p>
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 * <p>
 * 状态方程： dp[n-3] = dp[n-4] + max(nums[n-2] + nums[n], nums[n-1])
 * // todo 这里的状态方程， 我没有考虑到最后的情况， 总结规律， 很明显不是最后一个状态的方程， 所以必然是错的， 还是需要多练多总结
 * <p>
 * 正确的状态转移方程：dp[i] = max(dp[i-2] + nums[i], dp[i-1])  //这里的dp[i]代表前i间房子偷到的最多钱, i表示第i间房子，
 * 正确的状态转移方程就是所有情况都符合这个方程， 出了最开始的边界情况特殊处理， 那么我们需要找到所有情况都符合的最后的一种状态写成方程
 * // todo 这里的参数i表示的含义是不是直接表示为第i间房子比较容易呢， 如果是爬阶梯就表示成第i个阶梯， 下次分析类似的问题可以试试
 **/
public class 打家劫舍 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dp[i] = nums[i];
            } else if (i == 1) {
                dp[i] = Math.max(nums[i], nums[i - 1]);
            } else {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return Math.max(dp[nums.length - 1], dp[nums.length - 2]);
    }

    @Test
    public void DemoTest() {
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
    }
}
