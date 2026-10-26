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
Approach:
Repeatedly merge adjacent pairs of sorted linked lists using mergeTwoLists().
Store the merged lists in a new array for each iteration.
If the number of lists is odd, carry the last list over unchanged.
Repeat until only one list remains, then return its head.

Time: O(k + n log k)
Space: O(k)
*/

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        

        while(lists.length > 1){

            ListNode[] mergedList = new ListNode[(lists.length+1)/2];

            for(int i = 0 ; i < lists.length; i += 2){

                if(i+1 < lists.length){

                    mergedList[i/2] = mergeTwoLists(lists[i], lists[i+1]);
                }
                else{
                    mergedList[i/2] = lists[i];
                }

            }
            lists = mergedList;


        }

        return lists.length == 0 ? null : lists[0];



    }


     public ListNode mergeTwoLists(ListNode list1, ListNode list2)
    {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(list1 != null || list2 != null){

            if(list1 == null){
                current.next = list2;
                list2 = list2.next;
            }
            else if(list2 == null){
                current.next = list1;
                list1 = list1.next;
            }
            else{

                if(list1.val < list2.val ){

                    current.next = list1;
                    list1 = list1.next;
                   

                }
                else{
                    current.next = list2;
                    list2 = list2.next;
                }
           
                

            }

    current = current.next;

        }
        return dummy.next;

    }
}
