package cn.edu.cqu.nowcoder.string;

import java.util.Arrays;

/**
 * 表示数值的字符串
 */
public class Offer53 {
    public boolean isNumeric(char[] str) {
        String string = String.valueOf(str);
        return string.matches("[\\+\\-]?\\d*(\\.\\d+)?([Ee][\\+\\-]?\\d+)?");
    }
    /**
     * 自己写的，太繁琐
     * @param str
     * @return
     */
    public static boolean myIsNumeric(char[] str) {
        return isExpNumeric(str, 0, str.length - 1);
    }

    private static boolean isExpNumeric(char[] str, int start, int end) {
        if (end - start < 0) {
            return false;
        }
        for (int i = start; i <= end; i++) {
            if (str[i] == 'E' || str[i] == 'e') {
                return isOpFloatNumeric(str, start, i - 1) &&
                        isOpPureNumeric(str, i + 1, end);
            }
        }
        return isOpFloatNumeric(str, start, end);
    }

    private static boolean isOpFloatNumeric(char[] str, int start, int end) {
        if (end - start < 0) {
            return false;
        }
        if (str[start] == '+' || str[start] == '-') {
            return isFloatNumeric(str, start + 1, end);
        }
        return isFloatNumeric(str, start, end);
    }

    private static boolean isOpPureNumeric(char[] str, int start, int end) {
        if (end - start < 0) {
            return false;
        }
        if (str[start] == '+' || str[start] == '-') {
            return isPureNumeric(str, start + 1, end);
        }
        return isPureNumeric(str, start, end);
    }

    private static boolean isFloatNumeric(char[] str, int start, int end) {
        if (end - start < 0) {
            return false;
        }
        for (int i = start; i <= end; i++) {
            if (str[i] == '.') {
                return (isPureNumeric(str, start, i - 1) || (start == i))
                        && isPureNumeric(str, i + 1, end);
            }
        }
        return isPureNumeric(str, start, end);
    }

    private static boolean isPureNumeric(char[] str, int start, int end) {
        if (end - start < 0) {
            return false;
        }
        for (int i = start; i <= end; i++) {
            if (str[i] > '9' || str[i] < '0') {
                return false;
            }
        }
        return true;
    }
}
