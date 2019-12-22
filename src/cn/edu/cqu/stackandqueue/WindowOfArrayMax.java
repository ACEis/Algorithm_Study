package cn.edu.cqu.stackandqueue;
/**
 * leetcode 239. 滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口
 * 从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。
 * 滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 */

import java.util.Deque;
import java.util.LinkedList;

public class WindowOfArrayMax {
    public static void main(String[] args) {
        int[] a = {4, 3, 5, 4, 3, 3, 6, 7};
        int[] s = windowOfMax(a, 3);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }

    public static int[] windowOfMax(int[] array, int w){
        if (array.length == 0 || w == 0) {
            return new int[]{};
        }
        int[] result = new int[array.length - w + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            while(!deque.isEmpty() && array[deque.peekLast()] < array[i]){
                deque.pollLast();
            }
            deque.addLast(i);
            if(deque.peekFirst() == i - w){
                deque.pollFirst();
            }
            if(i >= w - 1){
                result[i - w + 1] = array[deque.peekFirst()];
            }
        }
        return result;
    }
}


