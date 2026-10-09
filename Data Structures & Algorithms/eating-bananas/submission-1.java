class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
       /*
        Approach:
        Use binary search to find the minimum eating rate k. The minimum possible
        rate is 1, and the maximum possible rate is the largest pile. For each
        candidate rate k, calculate the total hours needed to finish all piles.
        If the required hours are greater than h, k is too slow, so we increase
        the minimum rate. Otherwise, k works, so we search for a smaller rate.

        Key Insight:
        Instead of checking every possible eating rate from 1 to maxPile linearly,
        binary search lets us eliminate half of the possible rates after each check
        because if a rate is too slow, every smaller rate is also too slow.

        Time Complexity: O(n log(maxPile))
        Space Complexity: O(1)
*/
         
         
         
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
