package cn.edu.cqu.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * leetcode 99. Recover Binary Search Tree
 * 二叉搜索树中的两个节点被错误地交换。
 *
 * 请在不改变其结构的情况下，恢复这棵树。
 */
public class RecoverBinarySearchTree {
    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(5);
        TreeNode n3 = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n2 = new TreeNode(2);
        TreeNode nn1 = new TreeNode(-1);
        n5.left = n3;n5.right = n9;
        n3.left = nn1;n3.right = n2;
        recoverTree(n5);
    }





    public static void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> list = new ArrayList<>();
        TreeNode curr = root;
        while (!stack.empty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode temp = stack.pop();
            list.add(temp);
            curr = temp.right;
        }
        TreeNode wrongNode1 = new TreeNode(-1);
        TreeNode wrongNode2 = new TreeNode(-1);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).value > list.get(i + 1).value) {
                wrongNode1 = list.get(i);
                break;
            }
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).value < list.get(i - 1).value) {
                wrongNode2 = list.get(i);
                break;
            }
        }
        int val1 = wrongNode1.value;
        wrongNode1.value = wrongNode2.value;
        wrongNode2.value = val1;
    }
}
