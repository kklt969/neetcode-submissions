class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        /*
            
Approach:
Use binary search to find the candidate row by comparing the target
with the row's first and last values. If the target falls within the
row's range, perform a second binary search within that row. Otherwise,
move the row search left or right accordingly.

Key Insight:
Because each row's range comes entirely before the next row's range,
we can eliminate half of the rows at each step.
*/


        


        int leftOuter = 0;
        int rightOuter = matrix.length -1;

        while(leftOuter <= rightOuter){

            int mid = leftOuter + (rightOuter-leftOuter) /2;

            if(target < matrix[mid][0]){
                rightOuter = mid -1;
            }
            else if( target > matrix[mid][matrix[mid].length-1]){
                leftOuter = mid +1;
            }
            else {
                int innerLength = matrix[mid].length;

                int left  = 0;
                int right = innerLength -1;

                while(left <= right){

                    int innerMid = left + (right-left) /2;

                    if(matrix[mid][innerMid] == target){
                        return true;
                    }
                    else if(matrix[mid][innerMid] < target){
                        left = innerMid+1;
                    }
                    else{
                        right = innerMid - 1;
                    }
                }
                return false;


            }}
            
            
    

        return false;

    }


}
