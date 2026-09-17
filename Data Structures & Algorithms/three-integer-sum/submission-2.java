class Solution {

    /*
         Approach:
    Sort the array, then use a fixed i and two pointers (left and right)
    to find triplets whose sum is 0.

    Key Insight:
    Because the array is sorted, if the sum is too small, move left forward
    to increase the sum. If the sum is too large, move right backward to
    decrease the sum. Skip duplicate values to avoid duplicate triplets.

    Time Complexity: O(n²)
    Space Complexity: O(1) excluding the output.

    Edge Cases:
    Fewer than 3 elements, no valid triplets, and duplicate numbers.

    */


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
    Arrays.sort(nums);

    

    for(int i = 0 ; i < nums.length; i++){
        
        if(i > 0 && nums[i] == nums[i-1]){
            continue;
        }


        int left = i+1;
        int right = nums.length-1;

        while(left < right){
            int sum  = nums[i] + nums[left] + nums[right];
            if( sum < 0){
                left++;

            }
            else if(sum == 0){

                 ArrayList<Integer> triplet = new ArrayList<>();
                triplet.add(nums[i]);
                triplet.add(nums[left]);
                triplet.add(nums[right]);

                if(!result.contains(triplet)){
                      result.add(triplet);
                   
                }

                 left++;
                    right--;
              

            }
            else{
                right--;
            }


        }

    }
      
    return result;
    }
}
