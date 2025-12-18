package linkedList;

public class CheckPelindrom {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; this.next = null; }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalfStart = reverse(slow.next);
        ListNode firstHalfStart = head;
        ListNode secondHalfCopy = secondHalfStart; 
        boolean isPalin = true;

        while (secondHalfStart != null) {
            if (firstHalfStart.val != secondHalfStart.val) {
                isPalin = false;
                break;
            }
            firstHalfStart = firstHalfStart.next;
            secondHalfStart = secondHalfStart.next;
        }
        slow.next = reverse(secondHalfCopy);

        return isPalin;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }    public static void main(String[] args) {
        CheckPelindrom  sol = new CheckPelindrom ();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println(sol.isPalindrome(head)); 
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        System.out.println(sol.isPalindrome(head2)); 
    }
}

