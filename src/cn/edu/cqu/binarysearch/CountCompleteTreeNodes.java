package cn.edu.cqu.binarysearch;

/**
 * leetcode 222.Count Complete Tree Nodes
 * 给出一个完全二叉树，求出该树的节点个数。
 *
 * 说明：
 *
 * 完全二叉树的定义如下：在完全二叉树中，
 * 除了最底层节点可能没填满外，其余每层节点数都达到最大值，
 * 并且最下面一层的节点都集中在该层最左边的若干位置。
 * 若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 */

public class CountCompleteTreeNodes {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.right == null) return 2;
        int leftheight = 0;
        int rightheight = 1;
        TreeNode curr = root;
        while (curr != null){
            leftheight++;
            curr = curr.left;
        }
        curr = root.right;
        while (curr != null){
            rightheight++;
            curr = curr.left;
        }
        if (leftheight == rightheight){
            return (1 << (leftheight - 1)) + countNodes(root.right);
        }else {
            return (1 << (rightheight - 1)) + countNodes(root.left);
        }
    }
}
