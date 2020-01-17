package cn.edu.cqu.nowcoder;

import java.util.*;

public class  Offer62 {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        if (num.length == 0 || size == 0) {
            return new ArrayList<Integer>();
        }
        Deque<Integer> deque = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            while (!deque.isEmpty() && num[deque.peekLast()] <= num[i]){
                deque.pollLast();
            }
            deque.offer(i);
            if (deque.peekFirst() == i - size) {
                deque.pollFirst();
            }
            if (i >= size - 1) {
                res.add(num[deque.peekFirst()]);
            }
        }
        return res;
    }
}
    //利用优先队列构建最大堆
    /*
        ArrayList<Integer> list = new ArrayList<>();
        int len = num.length;
        if (len < size || size == 0) {
            return list;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < size; i++) {
            maxHeap.offer(num[i]);
        }
        for (int i = size; i < len; i++) {
            list.add(maxHeap.peek());
            maxHeap.remove(num[i - size]);
            maxHeap.offer(num[i]);
        }
        list.add(maxHeap.peek());
        return list;

     */
