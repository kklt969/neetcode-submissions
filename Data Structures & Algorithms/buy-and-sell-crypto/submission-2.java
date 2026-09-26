class Solution {
    public int maxProfit(int[] prices) {

        int profit = 0;
      int left = 0;
      int right = 1;

      while(right < prices.length){

        if(prices[left] > prices[right]){
            left = right;
        }
        else{
            int initialProfit = prices[right] - prices[left];
            if(initialProfit > profit){
                profit = initialProfit;
            }
        }

        right++;


      }

        return profit;

        
    }
}
