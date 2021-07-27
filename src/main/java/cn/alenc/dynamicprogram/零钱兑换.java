package cn.alenc.dynamicprogram;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定不同面额的营部coins和一个总金额amount，使用最少的硬币凑出总金额，凑不出返回-1
 * coins = [1,2,5], amount = 1
 * addCoins([1,2,5],11) =
 * 1 + min(addCoins[1,2,5],10), addCoins[1,2,5],9), addCoins[1,2,5],6))
 */
public class 零钱兑换 {

    int[] memo;

    public int addCoins(int[] coins, int amount){
        memo = new int[amount + 1];

        Arrays.fill(memo,-666);

        return dp(coins, amount);
    }

    //暴力解法
    public int dp(int[] coins, int amount) {

        if(amount == 0) return 0;
        if(amount < 0) return -1;

        if (memo[amount] != -666) {
            return memo[amount];
        }

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            int subproblem = dp(coins, amount - coins[i]);

            if (subproblem == -1) continue;

            res = Math.min(subproblem + 1, res);
        }
        memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return memo[amount];
    }

    @Test
    public void test(){
        System.out.println(addCoins(new int[]{1, 2, 5}, 50));
    }
}
