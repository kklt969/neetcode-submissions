class Solution {
    public int characterReplacement(String s, int k) {
/*
Approach:
Use a sliding window with two pointers. Expand the window using i and keep
track of the frequency of each character. Track the frequency of the most
common character in the current window. If the number of characters that
need to be replaced is greater than k, shrink the window by moving left.

Key Insight:
The number of replacements needed is:
windowLength - maxFrequency

We keep the most frequent character and replace all other characters.
If replacements > k, the window is invalid and we move left to shrink it.

Time Complexity: O(n)
Space Complexity: O(1)

Edge Cases:
- Empty string
- k = 0
- The entire string can already be one repeated character
- k is large enough to replace all other characters
*/

   
    int left = 0;
   
    int maxFrequency = 0;
    int result = 0;
    int[] freq = new int[26];

    for(int i = 0; i< s.length();i++){
        int index = s.charAt(i)- 'A';
        freq[index]++;
        maxFrequency = Math.max(maxFrequency, freq[index]);

        

        if(i - left+1  - maxFrequency > k){
            freq[s.charAt(left)- 'A']--;
            left++;
        }
        int windowLength = i - left+1;
        result = Math.max(result, windowLength);
        

    }
    return result;


    }
}
