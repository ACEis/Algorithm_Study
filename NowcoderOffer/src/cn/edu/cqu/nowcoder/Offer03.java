package cn.edu.cqu.nowcoder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Offer03 {
    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        ListNode curr = listNode;
        while (curr != null) {
            stack.push(curr.val);
            curr = curr.next;
        }
        while (!stack.empty()) {
            list.add(stack.pop());
        }
        return list;
    }
}
