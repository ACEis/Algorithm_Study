package cn.edu.cqu.nowcoder.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}

class Offer17{
    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root2 == null) {
            return false;
        }
        return HasSubtreeHelper(root1, root2);
    }

    private static boolean HasSubtreeHelper(TreeNode root1, TreeNode root2){
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        return ((root1.val == root2.val) &&
                HasSubtreeHelper(root1.left, root2.left) &&
                HasSubtreeHelper(root1.right, root2.right)) ||
                HasSubtreeHelper(root1.left, root2) ||
                HasSubtreeHelper(root1.right, root2);
    }
}

class Offer18{
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        Mirror(root.left);
        Mirror(root.right);
    }
}

/**
 * 从上到下打印二叉树
 */
class Offer22{
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            list.add(temp.val);
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
        return list;
    }
}

/**
 * 二叉搜索树的后序遍历序列
 */
class Offer23{
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return verifySquenceOfBSTHelper(sequence, 0, sequence.length - 1);
    }

    private static boolean verifySquenceOfBSTHelper(int[] sequence, int start, int end) {
        int len = end - start + 1;
        if (sequence == null || len < 4) {
            return true;
        }
        int root = sequence[end];
        int index = start;
        int rightIndex = start;
        while (index < end && sequence[index] < root) {
            index++;
        }
        rightIndex = index;
        while (index < end && sequence[index] > root) {
            index++;
        }
        if (index != end) {
            return false;
        }
        return verifySquenceOfBSTHelper(sequence, start, rightIndex - 1)
                && verifySquenceOfBSTHelper(sequence, rightIndex, end - 1);
    }
}

/**
 * 二叉树中和为某一值的路径
 */
class Offer24{
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        findPathHelper(lists, list, root, target);
        return lists;
    }

    private static void findPathHelper(ArrayList<ArrayList<Integer>> lists, ArrayList<Integer> list, TreeNode root, int target) {
        if (root == null) {
            list.add(root.val);
        }
        findPathHelper(lists, list, root.left, target - root.val);
        findPathHelper(lists, list, root.right, target - root.val);
        if (root.val == target && root.left == null && root.right == null) {
            lists.add(new ArrayList<>(list));
        }
        list.remove(list.size() - 1);
    }
}

/**
 * 二叉搜索树与双向链表
 */
class Offer26 {
    TreeNode pLast = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        TreeNode head = Convert(pRootOfTree.left);
        if (head == null) {
            head = pRootOfTree;
        }

        if (pLast != null) {
            pLast.right = pRootOfTree;
        }
        pRootOfTree.left = pLast;
        pLast = pRootOfTree;
        Convert(pRootOfTree.right);
        return head;
    }
}

/**
 * 二叉树的深度
 */
class Offer38{
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(1 + TreeDepth(root.left), 1 + TreeDepth(root.right));
    }
}

/**
 * 平衡二叉树
 */
class Offer39{
    public boolean IsBalanced_Solution(TreeNode root) {
        boolean[] isBalance = new boolean[1];
        isBalance[0] = true;
        getHeight(root, 1, isBalance);
        return isBalance[0];
    }

    private int getHeight(TreeNode root, int level, boolean[] isBalence) {
        if (root == null) {
            return level;
        }
        int leftHeight = getHeight(root.left, level + 1, isBalence);
        if (!isBalence[0]) {
            return level;
        }
        int rightHeight = getHeight(root.right, level + 1, isBalence);
        if (!isBalence[0]) {
            return level;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            isBalence[0] = false;
        }
        return Math.max(leftHeight, rightHeight);
    }
}