package linkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class DeleteNode {

    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) return;

        node.val = node.next.val;       
        node.next = node.next.next;    
    }
    public static void main(String[] args) {

        ListNode head = new ListNode(4,
                        new ListNode(5,
                        new ListNode(1,
                        new ListNode(9))));

       
        ListNode nodeToDelete = head.next; 
        DeleteNode sol = new DeleteNode();
        sol.deleteNode(nodeToDelete);
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}

