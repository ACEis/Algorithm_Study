package cn.edu.cqu.nowcoder;

import java.util.Arrays;

public class Offer04 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || pre.length == 0 || in == null || in.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        int index = indexOf(in, pre[0]);
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, index + 1), Arrays.copyOfRange(in, 0, index));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, index + 1, pre.length), Arrays.copyOfRange(in, index + 1, in.length));
        return root;
    }

    private int indexOf(int[] array, int i){
        for (int j = 0; j < array.length; j++) {
            if (array[j] == i) {
                return j;
            }
        }
        return -1;
    }
}
