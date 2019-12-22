package cn.edu.cqu.binarytree;
/**
 * leetcode 102. Binary Tree Level Order Traversal
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null){
            return lists;
        }
        queue.offer(root);
        TreeNode last = root;
        TreeNode nlast = root;
        TreeNode temp = null;
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            while (last != temp){
                temp = queue.poll();
                list.add(temp.value);
                if (temp.left != null){
                    nlast = temp.left;
                    queue.offer(nlast);
                }
                if (temp.right != null){
                    nlast = temp.right;
                    queue.offer(nlast);
                }
            }
            last = nlast;
            lists.add(list);
        }
        return lists;
    }
}
