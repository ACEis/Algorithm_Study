package cn.edu.cqu.nowcoder;

import java.util.Stack;

public class Offer60 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot == null) {
            return null;
        }
        int count = 0;
        TreeNode curr = pRoot;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode temp = stack.pop();
            if (++count == k) {
                return temp;
            }
            curr = temp.right;
        }
        return null;
    }


}
