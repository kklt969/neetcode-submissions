class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        /*
            I broke down the problem into 3 separate small problems.

            1. Row : I checked each Row by using hashset and return false if there is a duplicate number.

            2. Column :  I checked each Column by using hashset and return false if there is a duplicate number.

            3. 3x3 boxes : I checked by creating a nested loop for the box with +=3 increment for both rows and columns, then I ent into each value within that box by using i = row and j = col until it goes over the box boundary using hashset.

            Time complexity is O(n²) because we inspect every cell a constant number of times: once for its row, once for its column, and once for its 3×3 box.

        */


        HashSet<Character> set = new HashSet<>();

        for(int i = 0; i < board.length; i++) // condition 1 : ROW
        {
            for(int j = 0 ; j < board.length; j++)
            {
                char value = board[i][j];
                if(value != '.')
                {
                   if(!set.add(value))
                   {
                    return false;
                   }
                }

            }
            set.clear();

        }

        for(int i = 0; i < board.length; i++){ //condition 2 : COLUMN
            for(int j = 0; j < board.length; j++)
            {
                char value = board[j][i];
                if(value != '.')
                {
                    if(!set.add(value))
                    {
                        return false;
                    }
                }
            
            }

             set.clear();

        }


        for(int row = 0; row < board.length ; row += 3)
        {
            for(int col = 0; col < board.length; col += 3)
            {
                HashSet<Character> boxSet = new HashSet<>();

                 for(int i = row; i < row+3 ;  i++) 
                    {
                        for(int j = col ; j < col + 3; j++)
                        {
                            char value = board[i][j];
                            if(value != '.')
                            {
                            if(!boxSet.add(value))
                            {
                                return false;
                            }
                            }

                        }
            
                    }   
            
            }

        }

        return true;





    }
}
