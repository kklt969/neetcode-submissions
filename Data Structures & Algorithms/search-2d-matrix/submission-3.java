class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
       int leftOuter = 0;
       int rightOuter = matrix.length-1;

       while(leftOuter <= rightOuter){

        int outerMid = leftOuter + (rightOuter-leftOuter) / 2;

        if(target < matrix[outerMid][0]){

            rightOuter = outerMid-1;

        }

        else if(target > matrix[outerMid][matrix[outerMid].length-1]){
            leftOuter = outerMid+1;
        }
        else{

            int left = 0;
            int right = matrix[outerMid].length-1;

            while(left <= right)
            {
                int mid = left + (right-left)/2;

                if(target == matrix[outerMid][mid]){
                    return true;
                }
                else if(target > matrix[outerMid][mid] )
                {
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }
               
            }
             return false;

        }

       }
       return false;
      
    }
}
