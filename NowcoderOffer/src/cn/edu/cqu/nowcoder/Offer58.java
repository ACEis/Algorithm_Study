package cn.edu.cqu.nowcoder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Offer58 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot == null) {
            return lists;
        }
        TreeNode last = pRoot;
        TreeNode nlast = pRoot;
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            list.add(temp.val);
            if (temp.left != null) {
                queue.offer(temp.left);
                nlast = temp.left;
            }
            if (temp.right != null) {
                queue.offer(temp.right);
                nlast = temp.right;
            }
            if (temp == last) {
                lists.add(copy(list));
                list.clear();
                last = nlast;
            }
        }
        return lists;
    }

    private ArrayList<Integer> copy(ArrayList<Integer> list){
        ArrayList<Integer> copy = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            copy.add(list.get(i));
        }
        return copy;
    }
}
