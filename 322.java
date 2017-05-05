/**
322. Coin Change
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin.
*/

//Wrong answer, my thought is too complex
public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins==null||coins.length==0||amount<0)
        {
            return -1;
        }
        final int[][] minimumCoins = new int[coins.length+1][amount+1];
        
        for(int i = 1;i<=amount;i++)
        {
            minimumCoins[0][amount] = -1;
        }        
        for(int i = 1;i<=coins.length;i++)
        {
            //Dont need any coins to make up 0 amount
            minimumCoins[i][0] = 0;
            for(int target = 1; target<=amount;target++)
            {
                int min = minimumCoins[i-1][target];//Do not use current coin
                final int subTarget = target-coins[i-1];
                if(subTarget>=0)
                {
                    //Also use current coin
                    if(minimumCoins[i][subTarget]>=0)
                    {
                        if(min<0)
                        {
                           min = 1+minimumCoins[i][subTarget];
                        }
                        else
                        {
                          min = Math.min(min,1+minimumCoins[i][subTarget]);
                        }
                    }
                    //Do not use current coint
                    if(minimumCoins[i-1][subTarget]>=0)
                    {
                        if(min<0)
                        {
                           min = 1+minimumCoins[i-1][subTarget];
                        }
                        else
                        {
                          min = Math.min(min,1+minimumCoins[i-1][subTarget]);
                        }
                    }
                }
                minimumCoins[i][target] = min;
            }
        }
        
        return minimumCoins[coins.length][amount];
    }
}
//Correct answer
public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins==null||coins.length==0||amount<0)
        {
            return -1;
        }
        final int[] minimumCoins = new int[amount+1];
        //Dont need any coins to make up 0 amount
        minimumCoins[0] = 0;
        
        for(int target = 1;target<=amount;target++) 
        {
		    int min = -1;
        	for(int coin : coins) 
        	{
        		if(target >= coin && minimumCoins[target-coin]!=-1) 
        		{
        			int temp = minimumCoins[target-coin]+1;
        			min = min<0 ? temp : Math.min(temp,min);
            	}
            }
        	minimumCoins[target] = min;
    	}
	    return minimumCoins[amount];
    }
}