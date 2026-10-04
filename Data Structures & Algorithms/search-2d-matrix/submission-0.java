class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        for(int i = 0 ; i < matrix.length; i++){
            int innerLength = matrix[i].length;

            int left  = 0;
            int right = innerLength -1;

            while(left <= right){

                int mid = left + (right-left) /2;

                if(matrix[i][mid] == target){
                    return true;
                }
                else if(matrix[i][mid] < target){
                    left = mid+1;
                }
                else{
                    right = mid - 1;
                }
            }


        }
        return false;

    }
}
