package cn.alenc.dynamicprogram;

import org.junit.Test;

/**
 * @ClassName 使用最小花费爬楼梯
 * @Description
 * @Author ALLENC
 * @Date 2021/7/28 0:05
 * <p>
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
 * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
 * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 * <p>
 * 示例 1：
 * 输入：cost = [10, 15, 20]
 * 输出：15
 * 解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
 * <p>
 * 示例 2：
 * 输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出：6
 * 解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。
 * <p>
 * 提示：
 * cost 的长度范围是 [2, 1000]。
 * cost[i] 将会是一个整型数据，范围为 [0, 999] 。
 * <p>
 * 动态方程：dp[i]=min(dp[i−1]+cost[i−1],dp[i−2]+cost[i−2])
 * //todo 动态转移方程有多种形式， 但是边界处理是很重要的， 需要考虑到所有情况
 **/
public class 使用最小花费爬楼梯 {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }

        int[] dp = new int[cost.length + 1];

        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[cost.length];
    }

    /**
     * 动态方程：dp[i]=min(dp[i−1]+cost[i],dp[i−2]+cost[i-1])
     */
    public int minCostClimbingStairs1(int[] cost) {
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }

        int[] dp = new int[cost.length];
        //因为dp数组和cost数组的对应关系， 这里前两个数字就不能像上面那样直接赋值为0
        dp[0] = cost[0];
        dp[1] = Math.min(cost[0],cost[1]);

        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i], dp[i - 2] + cost[i - 1]);
        }

        return dp[cost.length-1];
    }

    @Test
    public void DemoTest() {
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        System.out.println(minCostClimbingStairs1(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
