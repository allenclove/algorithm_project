package cn.alenc._01数组.二分查找;

/**
 * @Auther: allenc
 * @Date: 2024/6/27 22:30
 * 简单
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * <p>
 * 示例 1：
 * 输入：x = 4
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 * <p>
 * 提示：
 * 0 <= x <= 231 - 1
 */
public class _69_x的平方根 {
    public static int mySqrt(int x) {
        int l = 0;
        int r = x;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if ((long) mid * mid > x) {
                r = mid - 1;
            } else if ((long) mid * mid <= x) { // k^2 <= x,也就是说最大的k就是答案。理解这个才是解题的关键
                ans = mid;
                l = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(8));
    }

    /**
     * 练习用
     */
    public static int mySqrt1(int x) {
        // k ^ 2 < x ，满足这个式子的最大值
        int l = 0;
        int r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid > x) { // r会指向小于x的第一个数字
                r = mid - 1;
            } else if ((long) mid * mid < x) { // l会指向大于x的第一个数字
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return l - 1;
    }
}
