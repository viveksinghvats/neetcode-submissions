class Solution {
    public int maxProfit(int[] prices) {
        int lastMinIndex = 0;
        int min = Integer.MAX_VALUE, max = 0;
        int profit = 0;

        for(int i = 0; i < prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
                lastMinIndex = i;
            }
            if(profit < (prices[i] - min) && i > lastMinIndex){
                max = prices[i];
                profit = Math.max(profit, Math.max(0, max - min));
            }
            
        }

        return profit;
    }
}
