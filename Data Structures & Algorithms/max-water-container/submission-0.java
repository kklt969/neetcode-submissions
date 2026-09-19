class Solution {

    /*
    Approach:
    Use two pointers, one at each end of the array. Calculate the area
    between the two walls and keep track of the maximum area.

    Key Insight:
    The container is limited by the shorter wall. Therefore, move the
    pointer at the shorter wall because moving the taller wall can only
    decrease the width without increasing the limiting height.

    Time Complexity: O(n)
    Space Complexity: O(1)

    Edge Cases:
    - Fewer than two heights.
    - Equal-height walls.
    - Maximum area occurs between non-adjacent walls.
*/

    public int maxArea(int[] heights) {

        int max = 0; 
        
        int i = 0; 
        int j = heights.length-1;

        while(i < j){

            int minHeight = Math.min(heights[i], heights[j]);

            int area = (j-i) *  minHeight;
            if(area > max){
                max = area;
            }

            if(heights[i] > heights[j]){

                j--;
            }
            else{
                i++;
            }

        }
       
         return max;
        
    }
}
