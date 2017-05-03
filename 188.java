/**
188. Best Time to Buy and Sell Stock IV
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

//This solution is wrong because one transaction is buy+sell!
public class Solution {
    public int maxProfit(int k, int[] prices) {
        if(k<=0||prices==null||prices.length==0)
        {
            return 0;
        }
        final int[][] cache = new int[k+1][prices.length];
        int max =0;
        
        cache[1][0] = -prices[0];
        for(int i = 1;i<=k;i++)
        {
            if(i>1)
            {
                cache[i][i-1] = cache[i-1][i-2]+(i%2==0?prices[i-1]:-prices[i-1]);
            }
            for(int j = i;j<prices.length;j++)
            {
                if(i%2==0)//Sell
                {
                    cache[i][j] = Math.max(cache[i][j-1],cache[i-2][j-2]+prices[j]);
                }
                else//buy
                {
                    cache[i][j] = Math.max(cache[i][j-1],cache[i-1][j-1]-prices[j]);
                }
            }
            max = Math.max(max,cache[i][prices.length-1]);
        }
        
        return max;
    }
}

//Correct solution
public class Solution {
    /**
     * dp[i, j] represents the max profit up until prices[j] using at most i transactions. 
     * dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
     * dp[0, j] = 0; 0 transactions makes 0 profit
     * dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj]) { jj in range of [0, j-1] }
     *          = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj]){ jj in range of [0, j-1] })
     */
     /**
      * 
        For example, if j == 8, then amongst all jj == 1,2,...,7
        The max profit could be one of the following:
        dp[i-1][0] + prices[8] - prices[0]
        dp[i-1][1] + prices[8] - prices[1]
        dp[i-1][2] + prices[8] - prices[2]
        ...
        dp[i-1][6] + prices[8] - prices[6]
        dp[i-1][7] + prices[8] - prices[7]
        
        localMax is the max value amongst all:
        dp[i-1][0] - prices[0]
        dp[i-1][1] - prices[1]
        dp[i-1][2] - prices[2]
        ...
        dp[i-1][6] - prices[6]
        dp[i-1][7] - prices[7]
        */
    public int maxProfit(int k, int[] prices) {
        if(k<=0||prices==null||prices.length==0)
        {
            return 0;
        }
        
        final int len = prices.length;
        
        //if k >= n/2, then you can make maximum number of transactions.
        if (k >= len / 2)
        {
            int profit = 0;
            for (int i = 1; i < len; i++)
            {
                // as long as there is a price gap, we gain a profit.
                if (prices[i] > prices[i - 1])
                {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }
        
        final int[][] cache = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int tmpMax =  -prices[0];
            for (int j = 1; j < len; j++) 
            {
                cache[i][j] = Math.max(cache[i][j - 1], prices[j] + tmpMax);
                tmpMax =  Math.max(tmpMax, cache[i - 1][j - 1] - prices[j]);
            }
        }
        return cache[k][len - 1];
    }
}