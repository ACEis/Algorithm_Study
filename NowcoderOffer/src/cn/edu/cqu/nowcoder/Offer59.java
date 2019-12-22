package cn.edu.cqu.nowcoder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("all")
public class Offer59 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        String str = Serialize(n1);
        System.out.println(str);
    }
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    static String Serialize(TreeNode root) {
        if (root == null) {
            return "#!";
        }
        StringBuffer sb = new StringBuffer();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp != null) {
                sb.append(temp.val + "!");
                queue.offer(temp.left);
                queue.offer(temp.right);
            }else {
                sb.append("#!");
            }
        }
        return sb.toString();
    }

    static TreeNode Deserialize(String str) {
        if (str == null || str.equals("#!")) {
            return null;
        }
        String[] strs = str.split("!");
        ArrayList<TreeNode> list = new ArrayList<>();
        TreeNode head = createNode(strs[0]);
        list.add(head);
        int rootIndex = 0;
        int childIndex = 1;
        while (rootIndex < list.size()) {
            TreeNode root = list.get(rootIndex++);
            root.left = createNode(strs[childIndex++]);
            root.right = createNode(strs[childIndex++]);
            if (root.left != null) {
                list.add(root.left);
            }
            if (root.right != null) {
                list.add(root.right);
            }
        }
        return head;
    }

    static private TreeNode createNode(String str){
        if (str == null || str.equals("#")) {
            return null;
        }
        return new TreeNode(Integer.parseInt(str));
    }























    String Serialize2(TreeNode root) {
        if (root == null) {
            return "#!";
        }
        String str = String.valueOf(root.val) + "!";
        str += Serialize2(root.left);
        str += Serialize2(root.right);
        return str;
    }

    TreeNode Deserialize2(String str) {
        String[] strs = str.split("!");
        ArrayList<TreeNode> list = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals("#")) {
                list.add(null);
            }else {
                list.add(new TreeNode(Integer.parseInt(strs[i])));
            }
        }
        return HelperDeserialize2(list);
    }

    private TreeNode HelperDeserialize2(ArrayList<TreeNode> list){
        if (list == null || list.size() == 0){
            return null;
        }
        if (list.get(0) == null){
            list.remove(0);
            return null;
        }
        TreeNode root = list.remove(0);
        root.left = HelperDeserialize2(list);
        root.right = HelperDeserialize2(list);
        return root;
    }
}
