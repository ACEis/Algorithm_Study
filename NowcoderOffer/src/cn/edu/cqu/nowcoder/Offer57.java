package cn.edu.cqu.nowcoder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Offer57 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot == null) {
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode last = pRoot;
        TreeNode nlast = pRoot;
        queue.offer(pRoot);
        boolean reverseFlag = false;
        ArrayList<Integer> list = new ArrayList<>();
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
                last = nlast;
                lists.add(copyList(list, reverseFlag));
                reverseFlag = !reverseFlag;
                list.clear();
            }
        }
        return lists;
    }

    private ArrayList<Integer> copyList(ArrayList<Integer> list, boolean flag){
        ArrayList<Integer> copy = new ArrayList<>();
        if (flag == false) {
            for (int i = 0; i < list.size(); i++) {
                copy.add(list.get(i));
            }
        }else {
            for (int i = list.size() - 1; i >= 0; i--) {
                copy.add(list.get(i));
            }
        }
        return copy;
    }
}
