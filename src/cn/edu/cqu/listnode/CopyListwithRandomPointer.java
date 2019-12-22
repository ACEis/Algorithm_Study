package cn.edu.cqu.listnode;

/**
 * leetcode 138.Copy List with Random Pointer
 * 给定一个链表，每个节点包含一个额外增加的随机指针，
 * 该指针可以指向链表中的任何节点或空节点。
 *
 * 要求返回这个链表的深拷贝。
 */

public class CopyListwithRandomPointer {
     static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
    public static void main(String[] args) {
        Node n3 = new Node(3, null, null);
        Node n2 = new Node(2, n3, null);
        Node n1 = new Node(1, n2, n3);
        n2.random = n1;
        n3.random = n2;
        copyRandomList(n1);
    }

    public static Node copyRandomList(Node head) {
        if (head == null) return null;
        Node curr = head;
        while(curr != null){
            Node copy = new Node(curr.val, curr.next, curr.random);
            curr.next = copy;
            curr = copy.next;
        }
        curr = head;
        while (curr != null){
            //注意点：即使curr不为空也无法保证random指针不为空
            // 防止random.next报异常要加入random指针检测
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        curr = head;
        Node result = head.next;
        while (curr.next.next != null){
            Node next = curr.next;
            curr.next = curr.next.next;
            next.next = next.next.next;
            curr = curr.next;
        }
        Node next = curr.next;
        //注意点：切断最后一个源节点与复制节点的指针
        curr.next = null;
        return result;
    }
}
