package cn.edu.cqu.nowcoder;

import java.util.List;

public class Offer54 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(1);
        ListNode n6 = new ListNode(2);
        ListNode n7 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        deleteDuplication(n1);
    }

    public static ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode Head = new ListNode(0);
        Head.next = pHead;
        ListNode pre = Head;
        ListNode last = Head.next;
        while (last != null) {
            if (last.next != null || last.val == last.next.val) {
                while (last.next != null && last.val == last.next.val) {
                    last = last.next;
                }
                pre.next = last.next;
                last = last.next;
            }else {
                pre = pre.next;
                last = last.next;
            }
        }
        return Head.next;
    }
}
