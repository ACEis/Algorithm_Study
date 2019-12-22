package cn.edu.cqu.binarytree;

/**
 * leetcode 110. Balanced Binary Tree
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 */

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        boolean[] res = new boolean[1];
        res[0] = true;
        getHeight(root, 1, res);
        return res[0];
    }

    public int getHeight(TreeNode root, int height, boolean[] res){
        if (root == null){
            return height;
        }
        int leftH = getHeight(root.left, height + 1, res);
        if (!res[0]){
            return height;
        }
        int rightH = getHeight(root.right, height + 1, res);
        if (!res[0]){
            return height;
        }
        if (Math.abs(leftH - rightH) > 1){
            res[0] = false;
        }
        return Math.max(leftH, rightH);
    }

}
