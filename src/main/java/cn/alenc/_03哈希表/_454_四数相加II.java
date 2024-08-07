package cn.alenc._03哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: allenc
 * @Date: 2024/8/6 22:00
 * 中等
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 *
 * 示例 1：
 * 输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
 * 输出：2
 * 解释：
 * 两个元组如下：
 * 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
 *
 * 示例 2：
 * 输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
 * 输出：1
 *
 *   提示：
 * n == nums1.length
 * n == nums2.length
 * n == nums3.length
 * n == nums4.length
 * 1 <= n <= 200
 * -228 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 228
 */
public class _454_四数相加II {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>(); // 这题没有什么特别的方法，很明显都需要遍历一下的，只需要用一层map去优化即可

        for (int i = 0; i < nums1.length; i++) { // 不用想如果有多个数组怎么办，反正都是要遍历一边的
            for (int j = 0; j < nums2.length; j++) { // 思路和两个数组的一样，先将2个数组的组合存储到map中，然后再取遍历另外两个数组的组合需要的数字是否在map中
                int sum = nums1[i] + nums2[j]; // 这里先将3个数组组合到map中也可以（遍历另外那个数组需要的值是否在map中），或者将一个数组放到map中也可以（遍历另外三个数组索要的值是否在map中）
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                } else {
                    map.put(sum, 1);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int sum = -(nums3[i] + nums4[j]);
                if (map.containsKey(sum)) {
                    result += map.get(sum);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
