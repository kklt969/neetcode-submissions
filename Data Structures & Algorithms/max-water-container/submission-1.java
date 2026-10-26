class Solution {
    public int maxArea(int[] heights) {
        
        int max = 0;

        int i = 0;
        int j = heights.length-1;

        while(i < j){

            int area = 0;
            int width = j-i;

            if(heights[i] > heights[j]){

                area = heights[j] * width;                
                j--;
            }
            else{
                area = heights[i] * width;   
                i++;
            }

            max = Math.max(max,area);


        }
        return max;


    }
}
