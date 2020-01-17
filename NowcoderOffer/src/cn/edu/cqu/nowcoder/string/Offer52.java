package cn.edu.cqu.nowcoder.string;

import java.util.Arrays;

/**
 *正则表达式匹配
 */
public class Offer52 {
    public static boolean match(char[] str, char[] pattern) {
        if (str == null && pattern == null) {
            return true;
        } else if (pattern == null) {
            return false;
        }
        return matchHelper(str, 0, pattern, 0);
    }

    private static boolean matchHelper(char[] str, int strIndex, char[] pattern, int patIndex) {
        if (strIndex >= str.length && patIndex >= pattern.length) {
            return true;
        } else if (patIndex >= pattern.length) {
            return false;
        }
        if (patIndex + 1 < pattern.length && pattern[patIndex + 1] == '*') {
            if (strIndex < str.length && (str[strIndex] == pattern[patIndex] || pattern[patIndex] == '.')) {
                return matchHelper(str, strIndex, pattern, patIndex + 2) ||
                        (matchHelper(str, strIndex + 1, pattern, patIndex));
            } else {
                return matchHelper(str, strIndex, pattern, patIndex + 2);
            }
        } else if (strIndex < str.length && (str[strIndex] == pattern[patIndex] || pattern[patIndex] == '.')) {
            return matchHelper(str, strIndex + 1, pattern, patIndex + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        char[] str = "".toCharArray();
        char[] pattern = ".*".toCharArray();
        System.out.println(match(str, pattern));
    }
}
