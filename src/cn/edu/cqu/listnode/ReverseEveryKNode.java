package cn.edu.cqu.listnode;

import java.util.Stack;

/**
 * leetcode 25.reverse-nodes-in-k-group
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 示例 :
 * 给定这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */

public class ReverseEveryKNode {
    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Node n = new Node(test);
        System.out.println(reverseKGroupStack(n, 2));
        n = new Node(test);
        System.out.println(reverseKGroup(n, 2));
    }

    public static Node reverseKGroupStack(Node head, int k) {
        if(head == null || k < 2){
            return head;
        }
        Stack<Node> stack = new Stack<>();
        Node lastRe = new Node(-1, null);
        Node result = head;
        //获取第K个节点作为返回节点
        for (int i = 0; i < k - 1; i++) {
            //不足K个直接返回不必调整
            if (result.next == null){
                return head;
            }
            result = result.next;
        }
        for (Node c = head; c != null; c = c.next) {
            stack.push(c);
            if (stack.size() == k){
                Node nextNode = c.next;
                while (!stack.empty()){
                    lastRe.next = stack.pop();
                    lastRe = lastRe.next;
                }
                lastRe.next = nextNode;
                c = lastRe;
            }
        }
        return result;
    }

    public static Node reverseKGroup(Node head, int k){

        Node dummy = new Node(0, null);
        dummy.next = head;

        Node pre = dummy;
        Node end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break;
            Node start = pre.next;
            Node next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    private static Node reverse(Node head){
        Node pre = null;
        Node curr = head;
        while (curr != null){
            Node next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
