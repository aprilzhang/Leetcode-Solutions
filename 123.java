/**
123. Best Time to Buy and Sell Stock III
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/
    /**
     * dp[i, j] represents the max profit up until prices[j] using at most i transactions. 
     * dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
     * dp[0, j] = 0; 0 transactions makes 0 profit
     * dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj]) { jj in range of [0, j-1] }
     *          = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj]){ jj in range of [0, j-1] })
     */
     /**
      * 
//one transaction is buy+sell!
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0)
        {
            return 0;
        }
        final int[][] cache = new int[3][prices.length];
        
        for(int i = 0;i<prices.length;i++)
        {
           cache[0][i] = 0; 
        }
        //First day cannot make any transaction
        cache[1][0] = 0;
        cache[2][0] = 0;
        
        for(int nTransaction = 1;nTransaction<=2;nTransaction++)
        {
            int localMax = -prices[0];
            for(int day = 1;day<prices.length;day++)
            {
                cache[nTransaction][day] = Math.max(cache[nTransaction][day-1],prices[day]+localMax);
                localMax = Math.max(localMax,cache[nTransaction-1][day-1]-prices[day]);
            }
        }
        
        return cache[2][prices.length-1];
    }
}