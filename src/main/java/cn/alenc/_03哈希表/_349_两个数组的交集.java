package cn.alenc._03哈希表;

import java.util.*;

/**
 * @Auther: allenc
 * @Date: 2024/8/3 22:19
 * 简单
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 *
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 *
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 *
 * 提示：
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 */
public class _349_两个数组的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Arrays.stream(nums1).forEach(list::add);

        Set<Integer> set = new HashSet<>();
        for (int i : nums2) {
            if (list.contains(i)) {
                set.add(i);
            }
        }
        return set.stream().mapToInt(Integer::intValue).toArray();

    }

    public static void main(String[] args) {

    }
}
