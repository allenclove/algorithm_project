package cn.alenc._01数组.长度最小的子数组;

/**
 * @Auther: allenc
 * @Date: 2024/7/2 22:11
 * 中等
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其总和大于等于 target 的长度最小的
 * 子数组
 * [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * <p>
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 * <p>
 * 提示：
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 * <p>
 * 进阶：
 * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 */
public class _209_长度最小的子数组 {
    public static int minSubArrayLen(int target, int[] nums) { // 暴力解法
        int min = 110;
        for (int i = 0; i < nums.length; i++) {
            int index = i;
            int sum = 0;
            int cnt = 0;
            while (index < nums.length && sum < target) {
                sum = nums[index] + sum;
                cnt++;
                index++;
            }
            if (sum >= target) {
                min = Math.min(min, cnt);
            }
        }
        if (min == 110) {
            return 0;
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println(minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
        System.out.println(minSubArrayLen1(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen1(4, new int[]{1, 4, 4}));
        System.out.println(minSubArrayLen1(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }

    public static int minSubArrayLen1(int target, int[] nums) { //滑动窗口，想到这个思路很重要，然后就是滑动窗口应该是右边先滑，然后是左边
        int left = 0;
        int sum = 0; // 滑动窗口的时候再进行相应的处理，不需要重置
        int min = nums.length + 1;
        int cnt = 0; // 滑动窗口的时候再进行相应的处理，不需要重置
        for (int right : nums) { // 控制滑动窗口的右边界
            sum += right;
            cnt++;
            while (sum >= target) { // 满足大于等于target再控制左边界
                if (sum - nums[left] >= target) {
                    sum -= nums[left];
                    left++;
                    cnt--;
                } else {
                    min = Math.min(min, cnt);
                    break;
                }
            }
        }
        if (sum >= target) {
            return min;
        } else {
            return 0;
        }
    }
}
