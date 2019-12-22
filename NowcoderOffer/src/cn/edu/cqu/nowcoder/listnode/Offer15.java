package cn.edu.cqu.nowcoder.listnode;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Offer15 {
    public ListNode ReverseList(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}

class Offer16{
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode res = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                res.next = list1;
                list1 = list1.next;
            }else {
                res.next = list2;
                list2 = list2.next;
            }
            res = res.next;
        }
        while (list1 != null) {
            res.next = list1;
            res = res.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            res.next = list2;
            res = res.next;
            list2 = list2.next;
        }
        return head.next;
    }
}

/**
 * 复杂链表的复制
 */
class Offer25 {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead == null) {
            return null;
        }
        RandomListNode curr = pHead;
        while (curr != null) {
            RandomListNode next = curr.next;
            RandomListNode brand = new RandomListNode(curr.label);
            curr.next = brand;
            brand.next = next;
            curr = next;
        }
        curr = pHead;
        RandomListNode res = curr.next;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        curr = pHead;
        while (curr != null && curr.next.next != null) {
            if (curr.next.next != null) {
                RandomListNode next = curr.next.next;
                curr.next.next = curr.next.next.next;
                curr.next = next;
                curr = next;
            }
        }
        curr.next = null;
        return res;
    }
}

/**
 * 两个链表的第一个公共节点
 */
class Offer36 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode node1 = pHead1;
        ListNode node2 = pHead2;
        while (node1 != node2) {
            node1 = (node1 == null) ? pHead2 : node1.next;
            node2 = (node2 == null) ? pHead1 : node2.next;
        }
        return node1;
    }
}
