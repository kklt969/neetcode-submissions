class LRUCache {

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