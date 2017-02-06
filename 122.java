/**
122. Best Time to Buy and Sell Stock II
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0)
        {
            return 0;
        }
        int profit = 0;
        int min = 0;
        boolean canSell = false;
        for(int i =0;i<prices.length;i++)
        {
            if(canSell)
            {
                if(i+1==prices.length||prices[i+1]<prices[i])
                {
                    profit += (prices[i]-min);
                    canSell = false;
                    if(i+1<prices.length)
                    {
                        min = prices[i+1];
                    }
                }
            }
            else if(i+1<prices.length)
            {
               min = Math.min(prices[i+1],prices[i]);
               canSell = true;
            }
        }
        return profit;
    }
}
//best solution
    public int maxProfit(int[] prices) {
        int total = 0;
        for (int i=0; i< prices.length-1; i++) {
            if (prices[i+1]>prices[i]) 
            {
                total += prices[i+1]-prices[i];
            }
        }
        
        return total;
    }