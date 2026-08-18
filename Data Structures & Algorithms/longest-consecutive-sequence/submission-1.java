class Solution {

    /*

    This solution uses hashset and counts for number only that is the start of the sequence. For eg : Input: nums = [2,20,4,10,3,4,5] , starts from 2 and loop through the whole array. There are two main linear passes, and the sequence traversals collectively are linear because we only expand from sequence starts, so the average time complexity is O(n).
    */


    public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();

        int count = 0;


           for(int i = 0 ; i < nums.length; i++){

                set.add(nums[i]);
            }

        

        for(int j = 0 ; j < nums.length; j++){

            int initialCount = 1;

            int current = nums[j];

             
            if(!set.contains(current - 1)){
                    
                while(set.contains(current + 1)){

                    current++;
                    initialCount++;

                }

             }

            if(initialCount > count){
                count = initialCount;
            }

        }

        return count;

    }
}
