package linkedList;

public class DetectCycle {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; this.next = null; }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;       
            fast = fast.next.next;   

            if (slow == fast) return true; 
        }

        return false; 
    }
    public static void main(String[] args) {
        DetectCycle sol = new DetectCycle();
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; 

        System.out.println(sol.hasCycle(head)); 

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        System.out.println(sol.hasCycle(head2)); 
    }
}

