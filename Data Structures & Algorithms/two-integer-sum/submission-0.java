class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap <Integer, Integer> map = new HashMap<>();

        int i;
        int j =0;

        for (i = 0 ; i < nums.length; i++)
        {
            int difference = (target - nums[i]);

           
            if(map.containsKey(difference))
            {
                j = map.get(difference);
                break;
            }

            map.put(nums[i], i);

        }

        return new int[]{j,i};
        

    }
}
