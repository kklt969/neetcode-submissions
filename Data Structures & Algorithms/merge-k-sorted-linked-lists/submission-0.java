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
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists.length == 0){
            return null;
        }

       

        // O(k)


        while(lists.length > 1)
        {
             ListNode[] mergedLists = new ListNode[(lists.length+1)/2];
            for(int i = 0 ; i < lists.length; i+= 2){
                if(i+1 < lists.length){

                    mergedLists[i/2] = mergeTwoLists(lists[i], lists[i+1]);
                }else{
                    
                    mergedLists[i/2] = lists[i];

                }
                

            }
            lists = mergedLists;
        }

        return lists[0];

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
