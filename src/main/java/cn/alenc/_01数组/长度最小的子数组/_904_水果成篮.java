package cn.alenc._01数组.长度最小的子数组;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: allenc
 * @Date: 2024/7/8 22:59
 * 中等
 * 你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。
 * 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
 * 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
 * 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
 * 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
 * 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。
 * <p>
 * 示例 1：
 * 输入：fruits = [1,2,1]
 * 输出：3
 * 解释：可以采摘全部 3 棵树。
 * <p>
 * 示例 2：
 * 输入：fruits = [0,1,2,2]
 * 输出：3
 * 解释：可以采摘 [1,2,2] 这三棵树。
 * 如果从第一棵树开始采摘，则只能采摘 [0,1] 这两棵树。
 * <p>
 * 示例 3：
 * 输入：fruits = [1,2,3,2,2]
 * 输出：4
 * 解释：可以采摘 [2,3,2,2] 这四棵树。
 * 如果从第一棵树开始采摘，则只能采摘 [1,2] 这两棵树。
 * <p>
 * 示例 4：
 * 输入：fruits = [3,3,3,1,2,1,1,2,3,3,4]
 * 输出：5
 * 解释：可以采摘 [1,2,1,1,2] 这五棵树。
 * <p>
 * 提示：
 * 1 <= fruits.length <= 105
 * 0 <= fruits[i] < fruits.length
 */
public class _904_水果成篮 {
    public static int totalFruit(int[] fruits) { // 巧妙的运用map来统计数量，还有滑动窗口，通过map确定窗口何时滑动。滑动窗口还可以使用一个for循环加上单独控制一个指针来实现，更加简单一点
        Map<Integer, Integer> map = new HashMap<>();
        map.put(fruits[0], 1);
        int start = 0;
        int end = 0;
        int max = -1;
        while (end < fruits.length - 1 && start <= end) {
            if (map.entrySet().size() < 2 || map.containsKey(fruits[end + 1])) {
                map.put(fruits[end + 1], map.getOrDefault(fruits[end + 1], 0) + 1);
                end++;
            } else {
                max = Math.max(max, end - start + 1);
                if (map.getOrDefault(fruits[start], 0) == 1) {
                    map.remove(fruits[start]);
                } else {
                    map.put(fruits[start], map.getOrDefault(fruits[start], 0) - 1);
                }
                start++;
            }
        }
        max = Math.max(max, end - start + 1);
        return max;
    }

    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{0, 0, 1, 1}));
        System.out.println(totalFruit(new int[]{1, 2, 1}));
        System.out.println(totalFruit(new int[]{0, 1, 2, 2}));
        System.out.println(totalFruit(new int[]{1, 2, 3, 2, 2}));
        System.out.println(totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
    }
}
