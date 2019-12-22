package cn.edu.cqu.nowcoder.dynamicprograming;

/**
 * 连续子数组的最大和
 */
public class Offer30 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
