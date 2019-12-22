package cn.edu.cqu.nowcoder;

public class Offer14 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode node = head;
        for (int i = 0; i < k; i++) {
            if (node == null) {
                return null;
            }
            node = node.next;
        }
        ListNode res = head;
        while (node != null) {
            node = node.next;
            res = res.next;
        }
        return res;
    }
}
