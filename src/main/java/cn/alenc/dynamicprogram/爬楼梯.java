package cn.alenc.dynamicprogram;

import org.junit.Test;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * //todo 难点：得出f(n) = f(n-1) + f(n-2) 的动态转移方程， 一开始知道要分解为最后一步， 也就是
 * 走到了还差一步的情况， 这一步可能是1， 可能是2， 但是这里的公式没有写出来（错误的公式：f(n) = f(n-1) + 1）， 没有明确返回值是方法种数， 参数是n阶楼梯
 * 其实把那个递归的树形图画出来找规律应该还是可以的， 就像以前高中学的求数列的通项公式一样
 *
 */
public class 爬楼梯 {
    public int climbStairs(int n) {
        if(n<4) {
            return n;
        }

        int prev = 2;
        int mid = 0;
        int res = 3;

        for (int i = 4; i <= n; i++) {
            mid = res;
            res += prev;
            prev = mid;
        }
        return res;
    }

    @Test
    public void demoTest(){
        System.out.println(climbStairs(4));
    }
}
