/**
62. Unique Paths
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 3 x 7 grid. How many possible unique paths are there?

Note: m and n will be at most 100.
*/
//First solution
//(m-1+n-1)!/(m-1)!(n-1)!
//but need to use big integer

//TLE
public class Solution {
    public int uniquePaths(int m, int n) {
        if(m==1||n==1)
        {
            return 1;
        }
        return uniquePaths(m-1, n)+uniquePaths(m, n-1);
    }
}

//Cache calculated result
public class Solution {
    public int uniquePaths(int m, int n) {
        if(m==1||n==1)
        {
            return 1;
        }
        
        final int[][] cache = new int[m][n];
        for(int i =0;i<m;i++)
        {
            cache[i][0] = 1;
        }
        for(int i =0;i<n;i++)
        {
            cache[0][i] = 1;
        }
        
        for(int i =1;i<m;i++)
        {
            for(int j =1;j<n;j++)
            {
                cache[i][j] = cache[i-1][j]+cache[i][j-1];
            }
        }
        return cache[m-1][n-1];
    }
}

