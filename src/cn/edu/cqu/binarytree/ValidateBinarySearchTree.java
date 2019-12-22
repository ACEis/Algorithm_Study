package cn.edu.cqu.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * leetcode 98. Validate Binary Search Tree
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 */
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        n2.left = n1;
        n2.right = n3;
        TreeNode n0 = new TreeNode(0);
        System.out.println(isValidBST(n1));
    }
    public static boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        long prevalue = Long.MIN_VALUE;
        while (!stack.isEmpty() || curr != null){
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode temp = stack.pop();
            if (temp.value <= prevalue){
                return false;
            }
            prevalue = temp.value;
            curr = temp.right;
        }
        return true;
    }
}
