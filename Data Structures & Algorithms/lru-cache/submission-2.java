class LRUCache {

    HashMap<Integer,Node> map = new HashMap<>();

    int capacity;

    Node head = new Node(0,0);
    Node tail = new Node(0,0);


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
        addNode(node);

        return node.value;

        
    }
    
    public void put(int key, int value) {
          if(map.containsKey(key)){

            Node existingNode = map.get(key);
            
            existingNode.value = value;

            remove(existingNode);
            addNode(existingNode);

            map.put(key,existingNode);
            

        }else{

            Node newNode = new Node(key,value);

            addNode(newNode);
            map.put(key,newNode);

             if(map.size() > capacity){
                
                Node nodeToRemove = head.next;
                map.remove(nodeToRemove.key);
                remove(nodeToRemove);
                
            }
               
    
        }
      
    }


    public void remove(Node node){

        node.prev.next= node.next;
        node.next.prev = node.prev;
     
    }

    public void addNode(Node node){
      tail.prev.next = node;
      node.prev = tail.prev;
      tail.prev= node;

      node.next= tail;

        

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