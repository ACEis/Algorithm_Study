package cn.edu.cqu.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 958. Check Completeness of a Binary Tree
 * 给定一个二叉树，确定它是否是一个完全二叉树。
 *
 * 百度百科中对完全二叉树的定义如下：
 *
 * 若设二叉树的深度为 h，除第 h 层外，
 * 其它各层 (1～h-1) 的结点数都达到最大个数，
 * 第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。（
 * 注：第 h 层可能包含 1~ 2h 个节点。）
 *
 */
public class CheckCompletenessofaBinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return true;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if (temp.right != null && temp.left == null){
                return false;
            }
            if (temp.right == null){
                if (temp.left != null){
                    queue.offer(temp.left);
                }
                while (!queue.isEmpty()){
                    TreeNode curr = queue.poll();
                    if (curr.left != null || curr.right != null){
                        return false;
                    }
                }
                return true;
            }
            queue.offer(temp.left);
            queue.offer(temp.right);
        }
        return true;
    }
}
