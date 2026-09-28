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

         ArrayList<ListNode> nodes = new ArrayList<>();

         ListNode current = head;

         while(current !=null){
            nodes.add(current);
            current  = current.next;
         }

        
        

         int left = 1;
         int right = nodes.size()-1;

        current = head;

       while(left < right){

        current.next = nodes.get(right);
        current = current.next;

        current.next = nodes.get(left);
        current = current.next;

        left++;
        right--;
       }

       if(left == right){
        current.next= nodes.get(left);
        current = current.next;
       
       }
        current.next= null;


        
    }
}
