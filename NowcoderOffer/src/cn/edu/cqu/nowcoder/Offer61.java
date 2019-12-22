package cn.edu.cqu.nowcoder;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class Offer61 {
    public static void main(String[] args) {
        LinkedList<Integer> l = new LinkedList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(l.size(), 4);
    }



































    /*
    优先队列写法

    private PriorityQueue<Integer> minHeap =  new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    int count = 0;


    public void Insert(Integer num) {
        if ((count & 1) == 0) {
            maxHeap.offer(num);
            int max = maxHeap.poll();
            minHeap.offer(max);
        }else {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        count++;
    }

    public Double GetMedian() {
        if ((count & 1) == 0) {
            return (double)(maxHeap.peek() + minHeap.peek()) / 2;
        }else {
            return (double)minHeap.peek();
        }

    }
     */
}
