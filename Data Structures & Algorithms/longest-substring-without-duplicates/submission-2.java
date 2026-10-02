class Solution {
    public int lengthOfLongestSubstring(String s) {
       
      /*
Approach:
Use a sliding window with a left pointer and a right pointer (i).
Expand the window by moving i forward. When a duplicate is found,
move left forward and remove characters from the HashSet until the
duplicate is removed. Track the maximum window length.

Key Insight:
The HashSet represents the characters currently inside the window,
so the window always contains unique characters.
*/
       
       
        HashSet<Character> set = new HashSet<>();
        int left= 0;
        
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
