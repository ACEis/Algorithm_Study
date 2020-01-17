package cn.edu.cqu.nowcoder.sort;

import java.util.ArrayList;
import java.util.Queue;

/**
 * 孩子们的游戏(圆圈中最后剩下的数)
 */
public class Offer46 {
    public int LastRemaining_Solution(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int curr = 0;
        while (list.size() > 1) {
            curr = (curr + m - 1) % list.size();
            list.remove(curr);
        }
        return list.get(0);
    }
}
