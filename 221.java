/**
221. Maximal Square
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
*/
//Correct solution
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null||matrix.length==0||matrix[0].length==0)
        {
            return 0;
        }
        
        final int rows = matrix.length;
        final int columns = matrix[0].length;
        final int[][] cache = new int[rows+1][columns+1];
        
        int maxSide = 0;
        for (int i = 1 ; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                if(matrix[i-1][j-1] == '1') {
                    cache[i][j] = Math.min(Math.min(cache[i][j-1] , cache[i-1][j-1]), cache[i-1][j]) + 1;
                    maxSide = Math.max(cache[i][j], maxSide); // update result
                }
            }
        }
        return maxSide*maxSide;
    }
}
//Buggy solution
//Trying to use a similiar way as in no.85 maximalRectangle problem
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null||matrix.length==0||matrix[0].length==0)
        {
            return 0;
        }
        
        final int rows = matrix.length;
        final int columns = matrix[0].length;
        
        final int[] height = new int[columns];
        
        for(int i = 0; i < columns; i ++)
        {
            if(matrix[0][i] == '1')
            {
                height[i] = 1;
            }
        }
        
        int result = largestSquare(height);
        
        for(int i = 1; i < rows; i ++){
            resetHeight(matrix, height, i);
            result = Math.max(result, largestSquare(height));
        }
        
        return result;
    }
    
    private void resetHeight(char[][] matrix, int[] height, int row){
        for(int i = 0; i < matrix[0].length; i++)
        {
            height[i] =matrix[row][i] == '1'? (height[i]+1):0;
        }
    }
    
    private int largestSquare(int[] height)
    {
        int maxSide = 0;
        for(int i = 0; i < height.length; i++)
        {
            if(maxSide>height[i])
            {
                i++;
                continue;
            }
            int tempMaxSide = Math.min(height[i],height.length-i);
            for(int j = i+1;j<i+tempMaxSide;j++)
            {
                tempMaxSide = Math.max(j-i,Math.min(tempMaxSide,height[j]));
            }
            
            maxSide = Math.max(tempMaxSide,maxSide);
        }
        
        return maxSide*maxSide;
    }
}