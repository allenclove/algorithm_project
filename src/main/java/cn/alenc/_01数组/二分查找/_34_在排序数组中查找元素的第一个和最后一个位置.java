package cn.alenc._01数组.二分查找;

import java.util.Arrays;

/**
 * @Auther: allenc
 * @Date: 2024/6/25 23:07
 * 中等
 * <p>
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * <p>
 * 示例 2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * <p>
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * <p>
 * 提示：
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 */
public class _34_在排序数组中查找元素的第一个和最后一个位置 {
    public static int[] searchRange(int[] nums, int target) {
        int l = searchIndex(nums, target);
        if (l == nums.length || nums[l] != target) {
            return new int[]{-1,-1};
        }
        int r = searchIndex(nums, target + 1) - 1; // 这里是很巧妙的地方：我要找target的最右边那个位置，我就先找比target大1的数，返回left边界，然后-1即可
        return new int[]{l, r};
    }

    /**
     * 记住循环不变式：l的左侧都是小于target的（那么l以及之后就是大于等于target的数字：如果target存在于数组中，则l指向最右侧的target，否则l指向大于target的数字），r的右侧都是大于等于target的，因此这里返回l即可，就是最左侧的target的位置
     * @param nums
     * @param target
     * @return
     */
    public static int searchIndex(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                // [mid+1,r]
                l = mid + 1;
            } else {
                // [l,mid - 1]
                r = mid - 1; // 这里不能等于mid，会死循环，想一想l，r，mid都指向同一个数时
            }
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(searchIndex(new int[]{5, 7, 7, 8, 8, 10}, 8));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 6)));
        System.out.println(Arrays.toString(searchRange(new int[]{}, 0)));
    }

    /**
     * 练习用
     */
    public static int[] searchRange1(int[] nums, int target) {
        int i = searchIndex1(nums, target);
        if (i == nums.length || nums[i] != target) {
            return new int[]{-1,-1};
        }
        return new int[]{i,searchIndex1(nums,target + 1) - 1};
    }

    /**
     * 练习用
     */
    public static int searchIndex1(int[] nums, int target) {
        // 循环不变式：l指向大于等于target的数字，也就是最左侧的target，l的左侧都是小于target的数字。r的右侧都是大于等于target的数字
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (nums[mid] >= target) {
                // [l,mid - 1]
                r = mid - 1;
            } else {
                // [mid + 1,r]
                l = mid + 1;
            }
        }
        return l;
    }
}
