class LRUCache {

/*
Approach:
Use a HashMap and a doubly linked list to achieve O(1) average time for get and put operations.

The HashMap maps each key to its corresponding node, allowing fast lookups. The doubly linked list maintains usage order: the most recently used node stays at the tail, while the least recently used node stays at the head.

When get accesses an existing key, move its node to the tail. When put updates an existing key, update its value and move it to the tail. For a new key, create a node, add it to the HashMap and tail of the list, and evict the head's next node if capacity is exceeded.

Time Complexity: O(1) average per get/put operation.
Space Complexity: O(capacity).
*/

    HashMap<Integer, Node>  map = new HashMap<>();
    Node head = new Node(0,0);
    Node tail = new Node(0,0);



    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
         head.next = tail;
        tail.prev = head;
  
        
    }
    
    public int get(int key) {
        
        if(!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);

        remove(node);
        addToTail(node);

        return node.value;

    }
    
    public void put(int key, int value) {

        if(map.containsKey(key)){

            Node existingNode = map.get(key);
            
            existingNode.value = value;

            remove(existingNode);
            addToTail(existingNode);

        }else{

            
            Node newNode = new Node(key,value);

           addToTail(newNode);
            map.put(key,newNode);
            
            if(map.size() > capacity){

                Node nodeToRemove = head.next;
                map.remove(nodeToRemove.key);
                remove(nodeToRemove);

            }

        }


        
    }
    
    public void remove(Node node){

        node.prev.next=  node.next;
        node.next.prev = node.prev;


    }

    public void addToTail(Node node){

        node.prev = tail.prev;
        node.prev.next = node;

        tail.prev = node;
        node.next = tail;

        
    }
    

}


class Node{

    int key;
    int value;

    Node next;
    Node prev;

    Node(){

    }

    Node(int key, int value){
        this.key = key;
        this.value = value;
    }

     Node(int key, int value, Node next, Node prev){
        this.key = key;
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
    


}