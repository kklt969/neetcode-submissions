class Solution {
    public int[] twoSum(int[] numbers, int target) {

       /*
    Approach:
    Use two pointers, with the left pointer starting at the beginning
    and the right pointer starting at the end. Calculate the sum of the
    two values. If the sum is greater than the target, decrement the
    right pointer. If the sum is less than the target, increment the
    left pointer.
    Continue until the target sum is found.

    Key Insight:
    Since the array is sorted, moving the right pointer left decreases
    the sum, while moving the left pointer right increases the sum.

    Edge Cases:
    The array contains at least two elements and exactly one valid
    solution is guaranteed.

    Time Complexity: O(n)
    Space Complexity: O(1)
*/



      int left = 0;
      int right = numbers.length-1;

      int result[]  = new int[2];

      while(left < right){

        int sum = numbers[left] + numbers[right];

        if(sum > target){
            right--;

        }
      

        else if(sum == target){

            result[0] = left +1;
            result[1] = right +1;
            break;


        }

         else{
            left++;
        }

      }

      return result;
        
    }
}
