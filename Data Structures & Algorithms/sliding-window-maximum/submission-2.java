class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        /*
Approach:
Use a max heap to keep indices ordered by their corresponding array values. Iterate through the array, adding each index to the heap.

For each position, remove indices from the top of the heap while they fall outside the current window. Once the first window is complete, the value at the top index is the maximum for that window, so store it in the result.

Use lazy deletion: expired indices can remain in the heap until they reach the top, where they are removed.

Time Complexity: O(n log n)
Space Complexity: O(n)
*/

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
