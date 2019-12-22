package cn.edu.cqu.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2, n3, null);
        TreeNode n1 = new TreeNode(1, null, n2);
        postorderTraversal(n1);
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.addFirst(node.value);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return output;
    }

    public static List<Integer> postorderTraversalWithStack(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null){
            return list;
        }
        stack.push(root);
        TreeNode h = root;
        TreeNode c = null;
        while (!stack.empty()){
            c = stack.peek();
            if (c.left != null && h != c.left && h != c.right){
                stack.push(c.left);
            }else if (c.right != null && h != c.right){
                stack.push(c.right);
            }else {
                h = stack.pop();
                list.add(h.value);
            }
        }
        return list;
    }

    public List<Integer> postorderTraversalWithTwoStack(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.empty()){
            TreeNode temp = s1.pop();
            s2.push(temp);
            if (temp.left != null){
                s1.push(temp.left);
            }
            if (temp.right != null){
                s1.push(temp.right);
            }
        }
        while (!s2.empty()){
            list.add(s2.pop().value);
        }
        return list;
    }
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        list.addAll(postorderTraversal2(root.left));
        list.addAll(postorderTraversal2(root.right));
        list.add(root.value);
        return list;
    }
}
