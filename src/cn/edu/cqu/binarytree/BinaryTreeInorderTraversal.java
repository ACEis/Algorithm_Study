package cn.edu.cqu.binarytree;
/**
 * leetcode 94. Binary Tree Inorder Traversal
 * 给定一个二叉树，返回它的中序 遍历。
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.empty()){
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode temp = stack.pop();
            list.add(temp.value);
            curr = temp.right;
        }
        return list;
    }

    //莫里斯中序遍历
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        TreeNode curr = root;
        TreeNode pre  = null;
        while (curr != null){
            if (curr.left == null){
                list.add(curr.value);
                curr = curr.right;
                continue;
            }
            pre = curr.left;
            while (pre.right != null && pre.right != curr){
                pre = pre.right;
            }
            if (pre.right == null){
                pre.right = curr;
                curr = curr.left;
                continue;
            }
            list.add(curr.value);
            pre.right = null;
            curr = curr.right;
        }
        return list;
    }

    //递归方法
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        list.addAll(inorderTraversal3(root.left));
        list.add(root.value);
        list.addAll(inorderTraversal3(root.right));
        return list;
    }
}
