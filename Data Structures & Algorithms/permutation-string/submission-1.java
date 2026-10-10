class Solution {
    public boolean checkInclusion(String s1, String s2)
     {
       /*
Approach:
Store the character frequencies of s1 in a frequency array. Create a second
frequency array for a sliding window in s2 with a length equal to s1.length().
Compare the two arrays. If they match, s2 contains a permutation of s1.
Otherwise, slide the window by removing the outgoing character's frequency
and adding the incoming character's frequency.

Key Insight:
A permutation contains the same characters with the same frequencies,
regardless of their order. Therefore, comparing frequency arrays lets us
check for a permutation without generating permutations or substrings.

Time Complexity: O(n), where n is the length of s2.
Space Complexity: O(1), since both frequency arrays have a fixed size of 26.
*/

        if(s1.length() > s2.length()){
            return false;
        }
        
       
        int[] freq1 = new int[26];

      for (int i = 0; i < s1.length(); i++) {
    freq1[s1.charAt(i) - 'a']++;
}

        int left = 0; 
        int right = s1.length();
        

        int[] freq2 = new int[26];

        for (int i = 0; i < s1.length(); i++) 
        {
            freq2[s2.charAt(i) - 'a']++;
        }

        while(right < s2.length()){
           
           if(Arrays.equals(freq1,freq2)){
             return true;
           }

           freq2[s2.charAt(left) - 'a']--;
           freq2[s2.charAt(right)- 'a']++;

           left++;
           right++;


        }
        if(Arrays.equals(freq1,freq2)){
             return true;
           }
        return false;

    }
}
