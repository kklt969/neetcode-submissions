class Solution {
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        // Find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split
        ListNode second = slow.next;
        slow.next = null;

        // Reverse second half
        second = reverseList(second);

        // Merge
        merge(head, second);
    }

    public ListNode reverseList(ListNode head) {

        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }

    public void merge(ListNode first, ListNode second) {

        while (second != null) {

            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }
    }
}