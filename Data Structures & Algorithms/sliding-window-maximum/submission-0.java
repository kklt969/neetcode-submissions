class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int[] result = new int[nums.length-k+1];

      
        
        int left = 0;
        int right = k;



        for(int i = 0 ; i < k ; i++){
            maxHeap.offer(nums[i]);
        }

        int j = 0;


        result[j] = maxHeap.peek();
        
        j++;

        while(right < nums.length){

           
            maxHeap.remove(nums[left]);
            
            
           maxHeap.offer(nums[right]); 
            

           result[j] = maxHeap.peek();

            left++;
            right++;
            j++;
            

        }

       
        
        return result;
        
    }
}
