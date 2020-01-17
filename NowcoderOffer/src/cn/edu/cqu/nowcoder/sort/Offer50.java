package cn.edu.cqu.nowcoder.sort;

import java.util.Arrays;

/**
 * 数组中重复的数字
 */
public class Offer50 {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        boolean[] exist = new boolean[length];
        Arrays.fill(exist, false);
        boolean result = true;
        for (int i = 0; i < length; i++) {
            if (numbers[i] < 0 || numbers[i] >= length) {
                result = false;
                continue;
            }
            if (exist[numbers[i]] == true) {
                duplication[0] = numbers[i];
                return result;
            }
            exist[numbers[i]] = true;
        }
        return false;
    }
}
