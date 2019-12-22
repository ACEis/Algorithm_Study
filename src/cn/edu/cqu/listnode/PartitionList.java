package cn.edu.cqu.listnode;

/**
 * leetcode 86.Partition List
 * 给定一个链表和一个特定值 x，对链表进行分
 * 隔，使得所有小于 x 的节点都在大于或等于 x 的
 * 节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 */
@SuppressWarnings("all")
public class PartitionList {
    public static void main(String[] args) {
        int[] test = {2, 0, 1, 2, 1, 1, 0, 1, 1, 2};
        Node n = new Node(test);
        System.out.println(n);
        System.out.println(partition(n, 1));
        n = new Node(test);
        System.out.println(partition3Node(n, 1));
    }

    public static Node partition(Node head, int x){
        Node smallh = new Node(0, null);
        Node small = smallh;
        Node bigh = new Node(0, null);
        Node big = bigh;
        while (head != null){
            if (head.val < x){
                small.next = head;
                small = small.next;
            }else{
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }

        big.next = null;
        small.next = bigh.next;
        return smallh.next;
    }

    public static Node partition3Node(Node head, int x){
        Node smallhead = new Node(-1, null);
        Node small = smallhead;
        Node bighead = new Node(-1, null);
        Node big = bighead;
        Node equalhead = new Node(-1, null);
        Node equal = equalhead;
        while (head != null){
            if (head.val < x){
                small.next = head;
                small = small.next;
            }else if (head.val > x){
                big.next = head;
                big = big.next;
            }else {
                equal.next = head;
                equal = equal.next;
            }
            head = head.next;
        }
        big.next = null;
        small.next = equalhead.next != null ? equalhead.next : bighead.next;
        equal.next = bighead.next != null ? bighead.next : null;
        return smallhead.next;
    }
}
