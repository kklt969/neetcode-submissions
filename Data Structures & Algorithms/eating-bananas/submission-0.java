class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
         int max = Arrays.stream(piles)
                        .max()
                        .getAsInt();
        int min = 1;

        

        while(max > min){

            int k = min + (max - min) /2;
            int hour = 0;
            for(int i = 0; i < piles.length; i++)   
            {
               hour += (int) Math.ceil((double) piles[i] / k);

            }

            if(hour > h){

                min = k+1;
            }
            else{
                
                
                max = k;
            }


        }
        return min;

    }
}
