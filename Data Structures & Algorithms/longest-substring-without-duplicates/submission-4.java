class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashSet<Character> set = new HashSet<>();

        int left =0;
        int right = 0;

        int length = 0;

        while(right < s.length()){

            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;

            }else{

                while(set.contains(s.charAt(right)))
                {
                 set.remove(s.charAt(left));
                 left++;
                }
                
            }

            int window = right-left;

            length = Math.max(length,window);


        }

        return length;

    }
}
