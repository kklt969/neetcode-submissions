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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);

        ListNode current = dummy;

        ListNode cur1 = l1;
        ListNode cur2 = l2;

        int carry = 0;

        int a = 0; 
        int b = 0;

        while(cur1 != null || cur2 != null){


            if(cur1 == null){
                a = 0;
                b = cur2.val;
                
            }
            else if(cur2 == null){
                b = 0;
                a = cur1.val;
               
            }else{
                a = cur1.val;
                b = cur2.val;
            }


            int sum = a+b+carry;
            carry = 0;
            int val = sum;

            if(sum / 10 > 0){
                    val = sum% 10;
                    carry = sum / 10;

                }
            current.next = new ListNode(val);

            current = current.next;

            if(cur1 == null){
                cur2 = cur2.next;
            }

            else if(cur2 == null){
                cur1 = cur1.next;
            }
            else{
                   cur1 = cur1.next;
                     cur2 = cur2.next;
            
            }

        }
        if(carry > 0){
            current.next = new ListNode(carry);
        }

        return dummy.next;

    }
}
