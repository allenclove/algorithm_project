package cn.alenc.dynamicprogram;

import org.junit.Test;

import java.util.Arrays;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，
 * 这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * <p>
 * 示例1：
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * <p>
 * 示例 3：
 * 输入：nums = [0]
 * 输出：0
 * <p>
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 * <p>
 * //因为房子围成了一个圈， 所以需要注意的是开头的房子和结尾的房子不能同时被偷，这时候就可以分成两种情况：
 * 1. nums[0]被偷，nums[n-1]不被偷，
 * 2. nums[0]不被偷，nums[n-1]不被偷，
 * <p>
 * 由于我想到存在nums[1],和nums[n-2]同时被偷，那么就存在nums[0]和nums[n-1]都不能被偷
 * 想到了这一点，就无法单纯的分为上面两种情况
 * <p>
 * 有一点我没有意识到， 如果说我就分成两种情况， 并且直接分别算出值取最大值
 * 这里的两种情况可以确认的是： 头不被偷， 或者尾不被偷， 这里我们就只需要直接排除掉头或者尾， 那么就永远都不会被偷
 * 剩余的房子也没有确定谁一定被偷， 谁一定不被偷， 都需要算出一个收益最高的偷法， 所以当我们排除掉头的时候，尾也是有可能不被偷的
 * 当我们排除掉尾的时候， 头也是可能不被偷的， 所以就符合了我上面说的第三种情况， 所以实际上分为这两种情况是合理的包括所有情况的
 */
public class 打家劫舍II {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }else if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }

        int[] nums1 =new int[nums.length-1];
        int[] nums2 =new int[nums.length-1];

        System.arraycopy(nums,1, nums1,0, nums.length-1);
        System.arraycopy(nums,0, nums2,0, nums.length-1);
        return Math.max(calculate(nums1),calculate(nums2));
    }

    public int calculate(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0],nums[1]);
            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
        }

        return Math.max(dp[nums.length - 1],dp[nums.length-2]);
    }


    @Test
    public void DemoTest() {
        System.out.println(rob(new int[]{1,2,3,1}));
    }
}
