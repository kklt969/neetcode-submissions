class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left= 0;
        int right =0;
        int maxWindowLength = 0;

        char[] chars = s.toCharArray();

        for(int i = 0 ; i < s.length(); i++){

            char c = chars[i];

            while(set.contains(c)){
                set.remove(chars[left]);
                left++;
            }    
            
            set.add(c);

             int windowLength = i - left+1;
                 if(windowLength > maxWindowLength){
                maxWindowLength = windowLength;
            }
            

           
        }
        
        return maxWindowLength;
    }
}
