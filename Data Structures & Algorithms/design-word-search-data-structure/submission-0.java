class WordDictionary {

    TrieNode root;

    public WordDictionary() {

        root = new TrieNode();

    }

    public void addWord(String word) {

        TrieNode current = root;

        for(int i = 0; i < word.length();i++){

            char c = word.charAt(i);

            if(current.children[c - 'a'] == null){
                TrieNode newNode = new TrieNode();
                current.children[c-'a'] = newNode;
            }
            current = current.children[c-'a'];

        }

        current.isWord = true;

    }

    public boolean search(String word) {
        return searchHelper(root,word,0);

    }

    private boolean searchHelper(TrieNode current, String word, int i){
        
        if(i == word.length()){
            return current.isWord;
        }   

        if(word.charAt(i) == '.'){

                for(int j = 0; j < 26; j++){
                if(current.children[j] != null){
                    if(searchHelper(current.children[j], word,i+1)){
                        return true;
                    }
                }

            }

            return false;

        }else{

            int index = word.charAt(i) - 'a';

            if(current.children[index] == null){
                return false;
            }

            return searchHelper(current.children[index],word,i+1);


        }


        
        
       
    }


}

class TrieNode{

    TrieNode[] children = new TrieNode[26];

    boolean isWord;

    public TrieNode(){

    }


}

