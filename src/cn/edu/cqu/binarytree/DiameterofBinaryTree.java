package cn.edu.cqu.binarytree;

/**
 * leetcode 543. Diameter of Binary Tree
 * 给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过根结点。
 */
public class DiameterofBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        return diameterOfBinaryTreehelper(root)[0];
    }

    /**
     * 返回
     * 第一个数 以根节点为头结点的树的直径
     * 第二个数 离根节点最远节点到根节点的距离
     * @param root
     * @return
     */
    private int[] diameterOfBinaryTreehelper(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        if (root.left == null && root.right == null) {
            return new int[]{0, 0};
        }
        int[] left = diameterOfBinaryTreehelper(root.left);
        int[] right = diameterOfBinaryTreehelper(root.right);
        int[] res = new int[2];
        int add = 2;
        if (root.left == null || root.right == null){
            add = 1;
        }
        res[0] = Math.max(Math.max(left[0], right[0]), left[1] + right[1] + add);
        res[1] = Math.max(left[1] + 1, right[1] + 1);
        return res;
    }










    //距离定义为路径上的节点数
    public int diameterOfBinaryTree2(TreeNode root) {
        return diameterOfBinaryTreehelper2(root)[0];
    }

    /**
     * 返回
     * 第一个数 以根节点为头结点的树的直径
     * 第二个数 离根节点最远节点到根节点的距离
     * @param root
     * @return
     */
    private int[] diameterOfBinaryTreehelper2(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        if (root.left == null && root.right == null) {
            return new int[]{1, 1};
        }
        int[] left = diameterOfBinaryTreehelper2(root.left);
        int[] right = diameterOfBinaryTreehelper2(root.right);
        int[] res = new int[2];
        res[0] = Math.max(Math.max(left[0], right[0]), left[1] + right[1] + 1);
        res[1] = Math.max(left[1] + 1, right[1] + 1);
        return res;
    }
}
