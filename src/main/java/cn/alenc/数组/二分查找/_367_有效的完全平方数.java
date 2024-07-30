package cn.alenc.数组.二分查找;

/**
 * @Auther: allenc
 * @Date: 2024/6/30 10:33
 * 简单
 * 给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * 完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。
 * 不能使用任何内置的库函数，如  sqrt 。
 * <p>
 * 示例 1：
 * 输入：num = 16
 * 输出：true
 * 解释：返回 true ，因为 4 * 4 = 16 且 4 是一个整数。
 * <p>
 * 示例 2：
 * 输入：num = 14
 * 输出：false
 * 解释：返回 false ，因为 3.742 * 3.742 = 14 但 3.742 不是一个整数。
 * <p>
 * 提示：
 * 1 <= num <= 231 - 1
 */
public class _367_有效的完全平方数 {
    public static boolean isPerfectSquare(int num) {
        int l = 0;
        int r = num;
        while (l <= r) {
            int mid = l + (r-l)/2;
            if ((long) mid * mid > num) {
                r = mid - 1;
            } else if ((long) mid * mid < num) {
                l = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
        System.out.println(isPerfectSquare(14));
    }
}
