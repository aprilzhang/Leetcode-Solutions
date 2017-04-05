/**
279. Perfect Squares
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
*/
//TLE
public class Solution {
    public int numSquares(int n) {
        return foundLess(n,0,n);
    }
    
    private static int foundLess(int number, final int currentLength, final int min)
    {
        //Longer than what we have found
        if(currentLength>min)
        {
            return min;
        }
        //Find result
        if(number == 0)
        {
            return currentLength;
        }
        
        int minLength = min;
        final int sqrt = (int) Math.sqrt(number);
        for(int i = sqrt;i>=1;i--)
        {
            minLength = foundLess(number-i*i,currentLength+1,minLength);
        }
        
        return minLength;
    }
}

//DP solution
//The least number of perfect square numbers of 0~n-1 are reused
public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        	Arrays.fill(dp, Integer.MAX_VALUE);
        	dp[0] = 0;
        	for(int i = 1; i <= n; i++) 
        	{
        	    final int sqrt = (int)Math.sqrt(i);
        		int min = Integer.MAX_VALUE;
        		for(int j =1;j<=sqrt;j++) 
        		{
        			min = Math.min(min, dp[i - j*j] + 1);
        		}
        		dp[i] = min;
        	}		
        	return dp[n];
    }
}

//Math solution
//Legendre's three-square theorem
public class Solution {
     public int numSquares(int n) {
        
        // If n is a perfect square, return 1.
        if(isSquare(n)) 
        {
            return 1;  
        }
        
        // The result is 4 if and only if n can be written in the 
        // form of 4^k*(8*m + 7). Please refer to 
        // Legendre's three-square theorem.
        while (n%4 == 0)  
        {
            n/=4;  
        }
        if (n%8 == 7) 
        {
            return 4;
        }
        
        final int sqrt = (int)Math.sqrt(n);
        // Check whether 2 is the result.
        for(int i = 1; i <= sqrt; i++)
        {  
            if (isSquare(n - i*i)) 
            {
                return 2;  
            }
        }  
        
        return 3; 
     }
     
     private static boolean isSquare(int n)
    {  
        final int sqrt = (int)Math.sqrt(n);  
        return sqrt*sqrt == n;  
    }
}