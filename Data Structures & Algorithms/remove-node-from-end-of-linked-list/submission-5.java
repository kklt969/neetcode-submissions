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
    public ListNode removeNthFromEnd(ListNode head, int n) {

      /*
Approach:
Use two pointers with a dummy node. Move the fast pointer n steps ahead,
then move both pointers together until fast reaches null. The slow pointer
will then be at the node before the one we need to remove.

Key Insight:
Keeping a gap of n nodes between fast and slow lets us find the nth node
from the end in one pass.

Time Complexity: O(n)
Space Complexity: O(1)

Edge Cases:
- Removing the head node
- Removing the last node
- A list with only one node
*/

        ListNode dummy  = new ListNode(0);
        dummy.next = head;
       ListNode slow = dummy; 
       ListNode fast = head;
        for(int i = 0 ; i < n;i++){
            fast= fast.next;
        }
    

        while(fast != null){
            slow = slow.next;
            fast = fast.next;
 
        }
          if(fast == null)
            {
                slow.next = slow.next.next;
            }

        return dummy.next;

    }
}
