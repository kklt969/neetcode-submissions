class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(nums);

        for(int i  = 0; i < nums.length;i++){


                if(i > 0 && nums[i] == nums[i-1]){
                    continue;
                }

            int j= i+1;
            int k = nums.length-1;





            while(j<k){

                int sum = nums[i]+nums[j]+nums[k];

                if(sum < 0){
                    j++;

                }

                else if(sum == 0){

                    ArrayList<Integer> triplets = new ArrayList<>();

                    triplets.add(nums[i]);
                    triplets.add(nums[j]);
                    triplets.add(nums[k]);

                    if(!list.contains(triplets)){

                        list.add(triplets);
                    }

                    j++;
                    k--;

                }
                else{
                    k--;
                }
                


            }
            


        }
        return list;
        
        
    }
}

/*
    -4,-1,-1,0,2,

    


*/