package cn.edu.cqu.nowcoder;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 第一个只出现一次的字符
 */
public class Offer34 {
    public int FirstNotRepeatingChar(String str) {
        int[] array = new int[58];
        for (int i = 0; i < str.length(); i++) {
            array[str.charAt(i) - 65]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (array[str.charAt(i) - 65] == 1) {
                return i;
            }
        }
        return -1;
    }
}
