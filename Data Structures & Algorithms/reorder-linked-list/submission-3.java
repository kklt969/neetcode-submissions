/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        
         if (head == null || head.next == null) {
            return;
        }
       ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //Split
        ListNode second = slow.next;
        slow.next = null;

        second = reverseList(second);

        merge(head,second);

        

    }

    public ListNode reverseList(ListNode head){

        ListNode prev = null;

        ListNode current = head;
        ListNode nextNode = null;

        while(current != null){

            nextNode = current.next;

            current.next = prev;

            prev = current;

            current = nextNode;


        }

        return prev;

    }

     public void merge(ListNode first, ListNode second){

            while(second != null){

                ListNode firstNext = first.next;
                ListNode secondNext = second.next;

                first.next = second;
                second.next = firstNext;

                first = firstNext;
                second=secondNext;


            }


     }
}
