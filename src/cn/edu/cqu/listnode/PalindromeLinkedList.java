package cn.edu.cqu.listnode;

import java.util.Stack;

/**
 * leetcode 234. palindrome-linked-list
 * 请判断一个链表是否为回文链表。
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        int[] test = {1, 2, 4, 5, 2, 1};
        ListNode n = new ListNode(test);
        System.out.println(isPalindrome(n));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null)   return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //如果需要恢复则保存reverse返回节点，对该节点reverse，返回结果加在slow后面
        // 在return前都加上这段代码
        ListNode next = slow.next;
        slow.next = null;
        next = reverse(next);
        ListNode curr = head;
        while (curr != null && next != null){
            if (curr.val != next.val){
                return false;
            }
            curr = curr.next;
            next = next.next;
        }
        return true;
    }

    private static ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode c = head;
        while (c != null){
            ListNode next = c.next;
            c.next = pre;
            pre = c;
            c = next;
        }
        return pre;
    }
}
