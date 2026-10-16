class Solution {
    public int findDuplicate(int[] nums) {


        

       /*
Approach:
Treat each array value as a pointer to the next index. Use slow and fast
pointers to detect a cycle, then reset one pointer to the starting value
and move both pointers one step at a time to find the cycle's entry,
which corresponds to the duplicate number.

Key Insight:
The duplicate value creates a cycle when array values are treated as
pointers. Floyd's cycle detection finds the cycle's entry without sorting
the array or using extra space.

Time Complexity: O(n)
Space Complexity: O(1)
*/


        

        int slow = nums[0];
        int fast = nums[0];


        do{
            slow = nums[slow];
            fast = nums[nums[fast]];

        }
        while(slow != fast);

        slow = nums[0];

        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
        
    }
}
