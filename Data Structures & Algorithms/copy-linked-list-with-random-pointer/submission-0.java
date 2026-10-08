/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {


       /*
Approach:
Create a copy of each node and store an Original Node -> Copied Node
mapping in a HashMap. Then iterate through the original list again and
use the HashMap to connect each copied node's next and random pointers
to the corresponding copied nodes.

Key Insight:
The HashMap lets us quickly find the copied version of any original node,
which allows us to correctly recreate both next and random pointers without
pointing back to the original list.

Time Complexity: O(n)
Space Complexity: O(n)

Edge Cases:
- Empty list
- random pointer is null
- random pointer points to itself
- random pointer points to any other node
*/
        
        HashMap<Node, Node> map = new HashMap<>();

        Node current = head;


        while(current != null){
            map.put(current, new Node(current.val));
            current = current.next;

        }

        current = head;
       

        while(current != null){

           Node copy =  map.get(current);

           copy.next = map.get(current.next);

           copy.random = map.get(current.random);

        current = current.next;

        }
        return map.get(head);

       

    }
}
