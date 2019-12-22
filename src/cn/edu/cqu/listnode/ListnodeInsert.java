package cn.edu.cqu.listnode;

/**
 * leetcode 708.Insert into a Cyclic Sorted List
 * 一个环形单链表从头节点 head 开始不降序，同时由最后的节
 * 点指回头节点。给定这样一个环形单链表的头节点 head 和 一
 * 个整数 num， 请生成节点值为 num 的新节点，并插入到这个
 * 环形链表中，保证调整后的链表依然有序。
 */

public class ListnodeInsert {
    public static void main(String[] args) {
        Node n3 = new Node(4,null);
        Node n2 = new Node(3, n3);
        Node n1 = new Node(1, n2);
        n3.next = n1;
        System.out.println(n1);
        System.out.println(insert(n1, -1));
    }

    public static Node insert(Node head, int insert){
        if(head == null) {
            return head;
        }
        Node inode = new Node(insert, null);
        Node p = head;
        Node c = p.next;
        for (; c != head ; p = p.next, c = c.next) {
            if(p.val <= insert && c.val >= insert){
                break;
            }
        }
        inode.next = c;
        p.next = inode;
        if (insert < head.val){
            return inode;
        }
        return head;
    }
}
