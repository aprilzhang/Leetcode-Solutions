/**
309. Best Time to Buy and Sell Stock with Cooldown
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

prices = [1, 2, 3, 0, 2]
maxProfit = 3
transactions = [buy, sell, cooldown, buy, sell]
*/
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
      
        int b0 = -prices[0]; //profit that buys at index i
        int b1 = b0;//profit that buys at index i-1
        int s0 = 0;//profit that we sell at index i
        int s1 = 0;//profit that we sell at index i-1
        int s2 = 0;//profit that we sell at index i-2
     
        for(int i = 1; i < prices.length; i++) 
        {
        	b0 = Math.max(b1, s2 - prices[i]);//do nothing or sell at i-2 and buy today
        	s0 = Math.max(s1, b1 + prices[i]);//do nothing or buy at i-1 and sell today
        	b1 = b0; s2 = s1; s1 = s0; 
        }
        return s0;
    }
}