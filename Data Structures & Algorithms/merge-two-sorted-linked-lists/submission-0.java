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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        

        ListNode l1 = list1;
        ListNode l2 = list2;

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(l1 != null || l2 != null){

            if(l1== null){
                current.next = l2;
                l2 = l2.next;
                

            }
            else if (l2 == null){
                current.next = l1;
                l1 = l1.next;
            }
            else{

                if(l1.val >= l2.val){

                    current.next = l2;
                    l2 = l2.next;
                   

                }
                else{
                    current.next = l1;
                    l1 = l1.next;
                    
                }
               
              
            }
              current = current.next;
              
              
             
        }

        return dummy.next;
        




    }
}