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

       /*
    Approach:
    Iterate through both linked lists, adding the values of the current nodes
    along with any carry from the previous addition. Create a new node containing
    the last digit of the sum and update the carry. Continue until both lists
    are exhausted.

    Key Insight:
    The new digit is sum % 10, and the carry is sum / 10. If a carry remains
    after both lists are exhausted, append one final node containing the carry.

    Time Complexity: O(max(m, n))
    Space Complexity: O(max(m, n))
*/
        
        ListNode dummy = new ListNode(0);
        
        ListNode newNode = dummy;

        int carry = 0;
        int digit1 = 0;
        int digit2 = 0;

        ListNode curr1 = l1;
        ListNode curr2 = l2;

        while(curr1 != null || curr2 != null){

            if(curr1 == null){
                digit1= 0;
                digit2 = curr2.val;
            }
            else if(curr2 == null){
                digit2 = 0;
                digit1 = curr1.val;
            }else{
                digit1 = curr1.val;
                digit2 = curr2.val;
            }
            

           int sum = digit1+digit2+carry;
           carry = 0;

           int result = 0;

           if(sum / 10 > 0){
            result = sum % 10;
            ListNode nextNode = new ListNode(result);
            newNode.next = nextNode;
            carry = sum/10;

           }else{
            ListNode nextNode = new ListNode(sum);
            newNode.next = nextNode;
           }


            if(curr1 == null){
                curr2 = curr2.next;
            }
            else if(curr2 == null){
                curr1= curr1.next;
            }
            else{
                    curr1= curr1.next;
                    curr2 = curr2.next;
            }

       
           newNode = newNode.next;


        }

        if(carry > 0){
           ListNode nextNode = new ListNode(carry);
            newNode.next = nextNode;

        }

        return dummy.next;



    }
}
