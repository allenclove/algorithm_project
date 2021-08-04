package cn.alenc.dynamicprogram;

import org.junit.Test;

/**
 * 给定一个非负整数数组nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * <p>
 * 示例1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * <p>
 * 示例2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * <p>
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * 0 <= nums[i] <= 105
 * <p>
 * 之前想的实在是太复杂了， 算法题做怕了， 这里可以确认的是当前的下标下， 跳跃的最大距离是可以确定的，
 * 所以我们只需要把所有跳跃距离算出来， 然后取最大的，然后再和数组长度比较就知道能不能到达最后一个下标
 *
 * 就是我不管你是什么情况， 得到你能去到的最远距离， 比较难想到的是前i-1个元素的最远距离和当前元素i的最远距离如何表达
 * 其实回头想想， 前i—1个元素的最远距离肯定是比较后取最大值， 当前元素i的距离就是当前元素的下标i加上值
 */
public class 跳跃游戏 {
    public boolean canJump(int[] nums) {
        int maxNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxNum) {
                //如果当前下标i大于前i-1个元素的最远距离， 那么根本就无法到达当前下标i
                return false;
            }
            //更新最远距离（前i-1个元素的最远距离：maxNum，当前i下标元素能到的最远距离：i+nums[i]）
            maxNum = Math.max(i + nums[i], maxNum);
        }
        return true;
    }

    @Test
    public void demoTest() {
        System.out.println(canJump(new int[]{3,2,1,0,4}));
        System.out.println(canJump(new int[]{2,3,1,1,4}));
    }
}
