class Solution {
    public int findMin(int[] nums) {

        /*
            Approach:
Use binary search to find the minimum element in the rotated sorted array.
If nums[mid] > nums[right], the minimum must be to the right of mid,
so set left = mid + 1. Otherwise, the minimum is at mid or to its left,
so set right = mid.

Key Insight:
We compare nums[mid] with nums[right] to determine which portion contains
the minimum. We keep mid in the search range when nums[mid] <= nums[right]
because mid itself could be the minimum.

Time Complexity: O(log n)
Space Complexity: O(1)
        */


        int left = 0;
        int right = nums.length -1;

        while(left < right){

            int mid = left + (right - left) / 2;

            if(nums[mid] > nums[right]){
                left = mid + 1;
            }
            else{
                right = mid;}


        }
        return nums[left];

        
    }
}
