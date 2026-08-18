class Solution {
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
