package cn.edu.cqu.dynamicprogramming;

/**
 * leetcode 1143. Longest Common Subsequence
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：
 * 它是由原字符串在不改变字符的相对顺序的情况下删除某些字符
 * （也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *
 * 若这两个字符串没有公共子序列，则返回 0。
 *
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1][len2];
        for (int i = 0; i < len1; i++) {
            if (text1.charAt(i) == text2.charAt(0)){
                for (int j = i; j < len1; j++) {
                    dp[j][0] = 1;
                }
                break;
            }
        }
        for (int i = 0; i < len2; i++) {
            if (text1.charAt(0) == text2.charAt(i)){
                for (int j = i; j < len2; j++) {
                    dp[0][j] = 1;
                }
                break;
            }
        }
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                int max = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (text1.charAt(i) == text2.charAt(j)) {
                    max = Math.max(max, dp[i - 1][j - 1] + 1);
                }
                dp[i][j] = max;
            }
        }
        return dp[len1 - 1][len2 - 1];
    }
}
