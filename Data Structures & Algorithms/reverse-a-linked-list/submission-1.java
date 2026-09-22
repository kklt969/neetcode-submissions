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

  /*
    Approach: Use two pointers, prev and current. Save the next node
    before changing the current node's pointer. Set current.next to prev
    to reverse the link, then update prev to current and current to the
    saved next node.
    
    Time Complexity: O(n)
    Space Complexity: O(1)
*/

    public ListNode reverseList(ListNode head) {
        
        ListNode current = head;
        ListNode nextNode = null;
        ListNode prev = null;

        while(current != null){

            nextNode = current.next;

            current.next = prev;

            prev = current;

            current = nextNode;


        }

        return prev;
      


    }
}
