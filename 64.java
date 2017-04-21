/**
64. Minimum Path Sum
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/
public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0)
        {
            return 0;
        }  
        final int row = grid.length;
        final int column = grid[0].length;      
        final int[][] cache = new int[row][column];
        cache[0][0]=grid[0][0];
        for(int i =1;i<row;i++)
        {
            cache[i][0]  =  cache[i-1][0]+ grid[i][0];
        }
        for(int i =1;i<column;i++)
        {
            cache[0][i]  =  cache[0][i-1]+ grid[0][i];
        }
        
        for(int i =1;i<row;i++)
        {
            for(int j =1;j<column;j++)
            {
                cache[i][j] = Math.min(cache[i-1][j],cache[i][j-1])+grid[i][j];
            } 
        }
        
        return cache[row-1][column-1];
    }
}