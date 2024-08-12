package cn.alenc._03哈希表;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Auther: allenc
 * @Date: 2024/8/11 13:36
 * 中等
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k
 * ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * <p>
 * 示例 2：
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * <p>
 * 示例 3：
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 * <p>
 * 提示：
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class _15_三数之和 {
    public static List<List<Integer>> threeSum(int[] nums) { // 暴力解法，会超时
        HashSet<HashSet<Integer>> resultSet = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (i != j && j != k && nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        HashSet<Integer> set = new HashSet<>(list);
                        if (!resultSet.contains(set)) {
                            resultSet.add(set);
                            result.add(list);
                        }
                    }
                }
            }
        }
        return result;
    }

    // 个人感觉还是比较难想到，尤其是去重的部分，思路可以学习
    public static List<List<Integer>> threeSum1(int[] nums) { // 使用三指针的滑动窗口，先排序
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) { // 如果排序后最小的数字都大于零，则直接返回
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) { // 指针a去重，假如是0，0，0，0。最终结果只能是一个0，0，0.所以这里跟前一次的相比，一样的话直接跳过
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    while (left < nums.length - 1 && right > left && nums[left] == nums[left + 1]) {
                        left++; // 指针b去重
                    }
                    while (right > 1 && right > left && nums[right] == nums[right - 1]) {
                        right--; // 指针c去重
                    }
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    left++;
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        threeSum1(new int[]{-1,0,1,2,-1,-4});
    }
}
