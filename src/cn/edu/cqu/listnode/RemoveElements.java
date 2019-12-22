package cn.edu.cqu.listnode;

public class RemoveElements {
    public static void main(String[] args) {
        int[] test = {1, 2, 6, 3, 4, 5, 6};
        Node n = new Node(test);
        System.out.println(removeElements(null, 6));
    }

    public static Node removeElements(Node head, int val) {
        Node result = new Node(0, null);
        Node copy = result;
        Node curr = head;
        while (curr != null){
            if (curr.val != val){
                copy.next = curr;
                copy = copy.next;
            }
            curr = curr.next;
        }
        copy.next = null;
        return result.next;
    }
}
