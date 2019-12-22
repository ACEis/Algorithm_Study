package cn.edu.cqu.binarytree;

/**
 * leetcode 285.Inorder Successor in BST
 * 二叉树中一个节点的后继节点指的是，二叉树的中序遍历的序列中的下一个节点。
 * 编写函数返回一个节点的后继节点
 */
public class InorderSuccessorinBST {
    class TreeNode{
        public int value;
        public TreeNode left;
        public TreeNode right;
        public TreeNode parent;
        public TreeNode(int data){
            this.value = data;
        }
    }

    //复杂一点的解法是向上遍历至根节点，中序遍历出所有节点，在其中找出后继节点
    public TreeNode SuccessorNode(TreeNode node){
        if (node.right != null) {
            TreeNode curr = node.right;
            while (curr.left != null) {
                curr = curr.left;
            }
            return curr;
        }
        TreeNode curr = node;
        while (curr.parent != null) {
            if (curr == curr.parent.left) {
                return curr.parent;
            }
            curr = curr.parent;
        }
        return null;
    }
}
