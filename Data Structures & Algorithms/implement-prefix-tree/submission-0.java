class PrefixTree {

    private TriNode root;

    public PrefixTree() {
          root = new TriNode();
    }

    public void insert(String word) {
        TriNode current = root;
        int i;

        for( i = 0; i < word.length(); i++){

            int index = word.charAt(i) - 'a';
            
            if(current.children[index] == null){
                current.children[index] = new TriNode();

             
            }
           current = current.children[index];
              

        }

         current.isWord = true;
    }

    public boolean search(String word) {

        TriNode current = root;

        for(int i = 0; i < word.length(); i++){

            int index = word.charAt(i) - 'a';
            
            if(current.children[index] == null){
                
                return false;
            }
           
           
           current = current.children[index];

        }

        return current.isWord;

    }

    public boolean startsWith(String prefix) {

          TriNode current = root;

        for(int i = 0; i < prefix.length(); i++){

            int index = prefix.charAt(i) - 'a';
            
            if(current.children[index] == null){
                
                return false;
             
            }
           
           current = current.children[index];

        }
        return true;


    }
}

class TriNode{


    TriNode[] children = new TriNode[26];
    boolean isWord = false;

   TriNode(){
    }

}
