class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {


        HashMap <String, List<String>> map = new HashMap<>();



        //aim for O(m*n), array to store char count() - > loop through each char in word to count the exact frequecy by using ASCII -> put the array.tostring in hashmapkey -> same frequency words will be added to the existing key as list

        for ( String word : strs){  

            int charsCount[] = new int [26];

            char[] chars = word.toCharArray();

            for(char c : chars){
                charsCount[c - 'a']++;
            }

            String key = Arrays.toString(charsCount);

            if(!map.containsKey(key))
            {
                map.put(key, new ArrayList<>());
            }


            map.get(key).add(word);
         

        }       

        return new ArrayList<>(map.values());



}

}
