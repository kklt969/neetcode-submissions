class Solution {

    

    public int longestConsecutive(int[] nums) {
        
        int longest = 1;

        if(nums.length == 0){
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();

        for(int num: nums){
            set.add(num);
        }

        for(int i = 0 ; i < nums.length; i++){
            int count = 1;

            if(!set.contains(nums[i]-1)){
                int check = nums[i]+1;

                while(set.contains(check)){
                    count++;
                    check++;
                    
                }
                longest= Math.max(longest,count);

            }

           

        }
        return longest;



    }
}
