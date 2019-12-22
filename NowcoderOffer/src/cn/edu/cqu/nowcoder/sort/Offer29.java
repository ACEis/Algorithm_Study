package cn.edu.cqu.nowcoder.sort;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 最小的K个数
 */
public class Offer29 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (k <= 0 || input.length < k) {
            return new ArrayList<>();
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (a, b) -> b.compareTo(a));
        for (int i = 0; i < k; i++) {
            queue.offer(input[i]);
        }
        for (int i = k; i < input.length; i++) {
            if (input[i] < queue.peek()) {
                queue.poll();
                queue.offer(input[i]);
            }
        }
        return new ArrayList<>(queue);
    }
}
