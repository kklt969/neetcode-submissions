class Solution {
    public int trap(int[] height) {

     /*
    Approach: Use two arrays to store the maximum height from the
    left and right for each position. For each position, the water
    level is determined by the shorter of the two tallest walls.
    Subtract the current height to get the trapped water.

    Time Complexity: O(n)
    Space Complexity: O(n)
*/
        
        int waterAmount = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        leftMax[0] = height[0];

        for(int i = 1; i<height.length;i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        rightMax[height.length - 1] = height[height.length - 1];
        for(int i = height.length-2; i>=0 ; i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }


        for(int i = 0; i < height.length; i++){

            waterAmount +=  Math.min(leftMax[i], rightMax[i]) -         height[i];

        }

        return waterAmount;



    }
}
