package cn.edu.cqu.binarytree;

import java.util.*;

/**
 * letcode 297. Serialize and Deserialize Binary Tree
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，
 * 进而可以将转换后的数据存储在一个文件或者内存中，
 * 同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。
 * 这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 提示: 这与 LeetCode 目前使用的方式一致，
 * 详情请参阅 LeetCode 序列化二叉树的格式。
 * 你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，
 * 你的序列化和反序列化算法应该是无状态的。
 **/
public class SerializeandDeserializeBinaryTree {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null){
                return "";
            }
            StringBuffer sb = new StringBuffer();
            Deque<TreeNode> deque = new LinkedList<>();
            deque.addLast(root);
            while (!deque.isEmpty()){
                TreeNode temp = deque.removeFirst();
                if (temp != null){
                    deque.add(temp.left);
                    deque.add(temp.right);
                    sb.append(temp.value).append(",");
                }else {
                    sb.append("null,");
                }
            }
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.length() == 0){
                return null;
            }
            String[] strs = data.split(",");
            List<TreeNode> list = new LinkedList<>();
            TreeNode head = createNode(strs[0]);
            list.add(head);
            int rootIndex = 0;
            int valueIndex = 1;
            while (rootIndex < list.size()){
                TreeNode root = list.get(rootIndex++);
                if (valueIndex < strs.length){
                    root.left = createNode(strs[valueIndex++]);
                    root.right = createNode(strs[valueIndex++]);
                }
                if (root.left != null){
                    list.add(root.left);
                }
                if (root.right != null){
                    list.add(root.right);
                }
            }
            return head;
        }

        private TreeNode createNode(String str){
            if (str == null || str.equals("null")){
                return null;
            }
            return new TreeNode(Integer.valueOf(str));
        }
    }

    //先序遍历
    public class Codec2 {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            String str = new String();
            if (root == null){
                return str + "null,";
            }
            str += root.value + ",";
            str += serialize(root.left);
            str += serialize(root.right);
            return str;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] nodes = data.split(",");
            List<String> data_list = new LinkedList<>(Arrays.asList(nodes));
            return helpdeserialize(data_list);
        }

        public TreeNode helpdeserialize(List<String> list){
            if (list.get(0).equals("null")){
                list.remove(0);
                return null;
            }
            TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
            list.remove(0);
            root.left = helpdeserialize(list);
            root.right = helpdeserialize(list);
            return root;
        }
    }
}

