package cn.edu.cqu.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * 丑数
 */
public class Offer33 {
    public int GetUglyNumber_Solution(int index) {
        int[] res = new int[index];
        int n2 = 0;
        int n3 = 0;
        int n5 = 0;
        res[0] = 1;
        for (int i = 1; i < index; i++) {
            res[i] = Math.min(Math.min(res[n2] * 2, res[n3] * 3), res[n5] * 5);
            if (res[i] == res[n2] * 2) {
                n2++;
            }
            if (res[i] == res[n3] * 3) {
                n3++;
            }
            if (res[i] == res[n5] * 5) {
                n5++;
            }
        }
        return res[index - 1];
    }
}

@SuppressWarnings("all")
class Temp{
    public static void main(String[] args) {
        for (char c = 'A'; c <= 'z'; c++) {
            System.out.println(c + " = " + (int)c);
        }
    }
}
