package cn.edu.cqu.dynamicprogramming;

/**
 * leetcode 518. Coin Change 2
 * 给定不同面额的硬币和一个总金额。
 * 写出函数来计算可以凑成总金额的硬币组合数。
 * 假设每一种面额的硬币有无限个。
 *
 *
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[][] res = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            res[i][0] = 1;
        }
        for (int i = 0; i < amount; i++) {
            if (i % coins[0] == 0) {
                res[coins.length][i] = 1;
            }else {
                res[coins.length][i] = 0;
            }
        }
        for (int i = 1; i < coins.length; i++) {
            for(int j = 1; j <= amount; j++){
                res[i][j] = res[i - 1][j] + (j - coins[i] >= 0 ? res[i][j - coins[i]] : 0);
            }
        }
        return res[coins.length - 1][amount];
    }
}
