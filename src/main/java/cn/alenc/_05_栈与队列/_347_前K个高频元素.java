package cn.alenc._05_栈与队列;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: allenc
 * @Date: 2024/8/21 21:01
 * 中等
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 * 提示：
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 *
 * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 */
public class _347_前K个高频元素 {
    public static int[] topKFrequent(int[] nums, int k) {  // 题解有点复杂了
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }

        Integer[] integers = map.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).limit(k).map(Map.Entry::getKey).toArray(Integer[]::new);

        return Arrays.stream(integers).mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,1,1,2,2,3},2)));
    }
}
