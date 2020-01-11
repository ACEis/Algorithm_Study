package cn.edu.cqu.nowcoder.sort;

import java.util.HashSet;
import java.util.Set;

/**
 * 扑克牌顺序
 */
public class Offer45 {
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length != 5) {
            return false;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                continue;
            } else if (set.contains(numbers[i])) {
                return false;
            } else {
                set.add(numbers[i]);
                min = Math.min(min, numbers[i]);
                max = Math.max(max, numbers[i]);
            }
        }
        if (max - min > 4) {
            return false;
        }
        return true;
    }
}
