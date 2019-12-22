package cn.edu.cqu.stackandqueue;

import java.util.HashMap;
import java.util.Stack;

/**
 * Leetcode 654.Maximum Binary Tree
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 *      1.二叉树的根是数组中的最大元素。
 *      2.左子树是通过数组中最大值左边部分构造出的最大二叉树。
 *      3.右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 */

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ val = x; }
}

public class ArrayToMaxTree {
    public static void main(String[] args) {
        int[] a = {3, 2, 1, 6, 0, 5};
        arrayToMaxTree(a);
    }

    public static TreeNode arrayToMaxTree(int[] array){
        HashMap<Integer, Integer> leftmap = new HashMap<>();
        HashMap<Integer, Integer> rightmap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        TreeNode root = null;
        TreeNode[] nodes = new TreeNode[array.length];
        for (int i = 0; i < array.length; i++) {
            nodes[i] = new TreeNode(array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            while (!stack.empty() && array[stack.peek()] < array[i]){
                stack.pop();
            }
            if(!stack.empty()){
                leftmap.put(i, stack.peek());
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = array.length - 1; i >= 0; i--) {
            while (!stack.empty() && array[stack.peek()] < array[i]){
                stack.pop();
            }
            if(!stack.empty()){
                rightmap.put(i, stack.peek());
            }
            stack.push(i);
        }
        for (int i = 0; i < array.length; i++) {
            TreeNode parent = null;
            int index = -1;
            if(leftmap.containsKey(i) && rightmap.containsKey(i)){
                index =  array[leftmap.get(i)] > array[rightmap.get(i)] ? rightmap.get(i) : leftmap.get(i);
                //parent = array[leftmap.get(i)] > array[rightmap.get(i)] ? nodes[rightmap.get(i)] : nodes[leftmap.get(i)];
            }else if (leftmap.containsKey(i)){
                index = leftmap.get(i);
                //parent = nodes[leftmap.get(i)];
            }else if (rightmap.containsKey(i)){
                index = rightmap.get(i);
                //parent = nodes[rightmap.get(i)];
            }
            if (index != -1){
                parent = nodes[index];
            }
            if (parent != null && index > i){
                parent.left = nodes[i];
            }else if(parent != null && index < i){
                parent.right = nodes[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (!leftmap.containsKey(i) && !rightmap.containsKey(i)){
                root = nodes[i];
                break;
            }
        }
        return root;
    }
}
