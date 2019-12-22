package cn.edu.cqu.listnode;

/**
 * leetcode 160. Intersection of Two Linked Lists
 *  编写一个程序，找到两个单链表相交的起始节点。
 *
 */

public class GetIntersectionNode {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode currA = headA;
        ListNode currB = headB;
        while (currA != currB){
            currA = currA.next;
            currB = currB.next;
            if (currA == null && currB == null){
                return null;
            }
            if (currA == null){
                currA = headB;
            }
            if (currB == null) {
                currB = headA;
            }
        }
        return currA;
    }
}
