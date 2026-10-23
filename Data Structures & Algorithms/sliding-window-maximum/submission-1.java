class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(nums[b],nums[a])  ) ;

        int[] result = new int[nums.length-k+1];

      
         for (int i = 0; i < nums.length; i++) {

            maxHeap.offer(i);

            while(maxHeap.peek() < i - k+1){
                maxHeap.poll();
            }

            if(i>=k-1){

                result[i-k+1] = nums[maxHeap.peek()];

            }


         }

       
        
        return result;
        
    }
}
