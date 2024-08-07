package cn.alenc._03哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: allenc
 * @Date: 2024/8/5 21:28
 * 简单
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 *
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 * 提示：
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 *
 * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 */
public class _1_两数之和 {
    public static int[] twoSum(int[] nums, int target) { // 暴力解法
        for (int j = 0; j < nums.length; j++) {
            for (int i = j + 1; i < nums.length ; i++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }
    public static int[] twoSum1(int[] nums, int target) { // 哈希表
        Map<Integer, Integer> map = new HashMap<>(); // 关键是这里，map存储的key是数组中的值，value是对应的索引
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) { // 判断当前数字差的值是否在map中，如果在直接返回
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
//        twoSum(new int[]{2,7,11,15}, 9);
        twoSum(new int[]{3,2,4}, 6);
    }
}
