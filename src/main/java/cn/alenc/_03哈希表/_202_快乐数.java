package cn.alenc._03哈希表;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: allenc
 * @Date: 2024/8/5 20:47
 * 简单
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」 定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 *
 * 示例 1：
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * 示例 2：
 * 输入：n = 2
 * 输出：false
 *
 * 提示：
 * 1 <= n <= 231 - 1
 */
public class _202_快乐数 {
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        Integer num = n;
        while (num != 1) {
            num = clac(set, num);
            if (1 == num) {
                return true;
            }
            if (set.contains(num)) { // 关键点是这里，如果说数字已经在set中，说明后面将是无限循环
                return false;
            }
        }

        return true;
    }

    public static Integer clac(Set<Integer> set, int n) {
        set.add(n);
        Integer result = 0;
        String nums = String.valueOf(n);
        for (int i = 0; i < nums.length(); i++) {
            Integer integer = Integer.valueOf(nums.charAt(i) + "");
            result += integer * integer;
        }
        return result;
    }

    public static void main(String[] args) {
        isHappy(1);
    }
}
