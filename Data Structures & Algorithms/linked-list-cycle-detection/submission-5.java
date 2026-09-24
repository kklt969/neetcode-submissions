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
    public boolean hasCycle(ListNode head) {
        
       /*
Approach: Use two pointers, slow and fast. Slow moves one node at a time
and fast moves two nodes. Return true if slow == fast.

Key Insight: If there is a cycle, fast gains one node on slow during each
iteration, so they will eventually meet at the same node.

Time Complexity: O(n)
Space Complexity: O(1)
*/


        ListNode slow = head;

        ListNode fast = head;


        while(fast != null && fast.next != null){

            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                return true;
            }


        }
        return false;

       
    }
}
