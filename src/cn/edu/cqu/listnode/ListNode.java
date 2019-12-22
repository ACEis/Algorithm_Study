package cn.edu.cqu.listnode;

public class ListNode extends Node{

    public int val;
    public ListNode next;
    public ListNode(){}

    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }

    public ListNode (int[] array){
        ListNode[] nodes = new ListNode[array.length];
        for (int i = 0; i < array.length; i++) {
            nodes[i] = new ListNode(array[i], null);
        }
        for (int i = array.length - 2; i >= 0; i--) {
            nodes[i].next = nodes[i + 1];
        }
        this.val = nodes[0].val;
        this.next = nodes[0].next;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        ListNode n = this;
        //循环链表输出写法
        //boolean flag = true;
        //for(; n != this || flag; n = n.next){
        for(; n != null; n = n.next){
            sb.append(n.val + " -> ");
            //    flag = false;
        }
        sb.setCharAt(sb.lastIndexOf("-"), ' ');
        sb.setCharAt(sb.lastIndexOf(">"), ' ');
        return sb.toString();
    }
}
