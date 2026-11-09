class Solution {
    public int characterReplacement(String s, int k) {

        int window = 0;
        int left = 0;

        int mostFreq = 0;

        int[] chars = new int[26];

        for(int i = 0 ; i < s.length(); i++){

            int index = s.charAt(i) - 'A';
            chars[index]++;

            mostFreq = Math.max(mostFreq,chars[index]);

            if(i - left+1 - mostFreq > k)
            {   
                chars[s.charAt(left) - 'A']--;
                left++;
            }

            int length = i - left+1;

            window = Math.max(length,window);

        }

        return window;
        
    }
}
