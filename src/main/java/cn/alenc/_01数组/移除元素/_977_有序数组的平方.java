package cn.alenc._01数组.移除元素;

import java.util.Arrays;

/**
 * @Auther: allenc
 * @Date: 2024/7/1 21:27
 * 简单
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * <p>
 * 示例 1：
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * <p>
 * 示例 2：
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * <p>
 * 提示：
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 已按 非递减顺序 排序
 * <p>
 * 进阶：
 * 请你设计时间复杂度为 O(n) 的算法解决本问题
 */
public class _977_有序数组的平方 {
    public static int[] sortedSquares(int[] nums) { // 思路：前后双指针，比较大小，然后给新数组倒序赋值。（之前这里有误区，双指针每次都是同时移动，应该是取大的赋值，然后移动对应的指针）
        int start = 0;
        int end = nums.length - 1;
        int[] arr = new int[nums.length];
        int endIndex = nums.length - 1;
        while (start <= end) {
            if (-nums[start] > nums[end]) {
                arr[endIndex] = nums[start] * nums[start];
                start++;
            } else {
                arr[endIndex] = nums[end] * nums[end];
                end--;
            }
            endIndex--;
        }
        return arr;
}

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4,-1,0,3,10})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-7,-3,2,3,11})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-5,-3,-2,-1})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-5, -4, -3, -2, -1})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{0, 2})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-1,2,2})));
    }

    public static int[] sortedSquares1(int[] nums) { // 简单的方式，但是性能不是最佳
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
