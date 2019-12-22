package cn.edu.cqu.nowcoder;

public class Offer55 {
    public static void main(String[] args) {
        TreeLinkNode t1 = new TreeLinkNode(1);
        TreeLinkNode t2 = new TreeLinkNode(2);
        TreeLinkNode t3 = new TreeLinkNode(3);
        TreeLinkNode t4 = new TreeLinkNode(4);
        TreeLinkNode t5 = new TreeLinkNode(5);
        t1.left = t2;t2.next = t1;
        t1.right = t3;t3.next = t1;
        t2.left = t4;t4.next = t2;
        t2.right = t5;t5.next = t2;
        System.out.println(GetNext(t4).val);
    }
    public static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public static TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode.right != null) {
            TreeLinkNode temp = pNode.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        }
        TreeLinkNode curr = pNode;
        while (curr.next != null) {
            if (curr == curr.next.left) {
                return curr.next;
            }
            curr = curr.next;
        }
        return null;
    }

}
