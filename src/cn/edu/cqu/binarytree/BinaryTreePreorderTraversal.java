package cn.edu.cqu.binarytree;
/**
 * leetcode 144.Binary Tree Preorder Traversal
 * 给定一个二叉树，返回它的 前序 遍历。
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()){
            TreeNode temp = stack.pop();
            if (temp.right != null){
                stack.add(temp.right);
            }
            if (temp.left != null){
                stack.add(temp.left);
            }
            list.add(temp.value);
        }
        return list;
    }
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        TreeNode currNode = root;
        list.add(root.value);
        list.addAll(preorderTraversal2(root.left));
        list.addAll(preorderTraversal2(root.right));
        return list;
    }
}
