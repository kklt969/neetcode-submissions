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

        ListNode current  = head;

        int length = 0;
        while(current != null){
            length++;
            current = current.next;
        }

        if(length == 0 ){
            return null;
        }

        if(n == length){
            return head.next;
        }

        ListNode prevNode = head;

        for(int i = 0 ; i < length - n;i++){

          if(i == length - n -1){
            prevNode.next = prevNode.next.next;
          }else{
            prevNode = prevNode.next;
          }
          

        }
       
        return head;

    }
}
