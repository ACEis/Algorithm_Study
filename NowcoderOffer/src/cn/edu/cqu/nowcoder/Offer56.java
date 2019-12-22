package cn.edu.cqu.nowcoder;


import java.util.ArrayList;
import java.util.Stack;

public class Offer56 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null) {
            return true;
        }
        return isEqual(pRoot.left, pRoot.right);
    }

    private boolean isEqual(TreeNode node1, TreeNode node2){
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val == node2.val) {
            return isEqual(node1.left, node2.right) && isEqual(node1.right, node2.left);
        }
        return false;
    }


    static boolean isSymmetrical2(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        ArrayList<String> left = ser2(pRoot.left);
        ArrayList<String> right = ser2(pRoot.right);
        if (left.size() != right.size()) {
            return false;
        }
        int i = 0;
        int len = left.size() - 1;
        while (len - i >= 0) {
            if (!left.get(i).equals(right.get(len - i))){
                return false;
            }
            i++;
        }
        return true;
    }

    static private ArrayList<String> ser2(TreeNode root){
        ArrayList<String> list = new ArrayList<>();
        if (root == null) {
            list.add("#");
        }
        else {
            list.addAll(ser2(root.left));
            list.add(String.valueOf(root.val));
            list.addAll(ser2(root.right));
        }
        return list;
    }
}
