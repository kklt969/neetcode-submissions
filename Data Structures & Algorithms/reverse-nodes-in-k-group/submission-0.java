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

 /*

    1. Reverse group for num k. 

    2. link last element of first k group to next group's head.

    3. reverse next group if it has enough k element. 

    4. repeatedly so on.

 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode dummy = new ListNode(0);
        ListNode prevGroupTail = dummy;

        dummy.next = head;
        ListNode current = head;
        

         while(true){

            int nodeCount = 0;

            ListNode check = current;

            for(int i = 0; i < k; i++){
                if(check !=null){
                    nodeCount++;
                    check=check.next;
                }
                else{
                    break;
                }
            }
            if(nodeCount < k){
                break;
            }
            ListNode groupTail = current;
            ListNode nextGroup = check;

            ListNode newHead = reserveKNodes(current,k);

            prevGroupTail.next = newHead;

            groupTail.next = nextGroup;
            
            prevGroupTail = groupTail;

            current = nextGroup;
            

         }
         return dummy.next;

    }

    private ListNode reserveKNodes(ListNode head, int k ){

        ListNode current = head;
         ListNode nextNode = null;
        ListNode prev = null;
        for(int i = 0; i < k; i++){

             nextNode = current.next;
             current.next = prev;
            
            prev = current;
            current = nextNode;
           

        }
        return prev;


    }
}
