/**
85. Maximal Rectangle
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 6.
*/
/**
Solution
We can apply the maximum in histogram in each row of the 2D matrix. What we need is to maintain an int array for each row, which represent for the height of the histogram.

Please refer to https://leetcode.com/problems/largest-rectangle-in-histogram/ first.

Suppose there is a 2D matrix like

1 1 0 1 0 1

0 1 0 0 1 1

1 1 1 1 0 1

1 1 1 1 0 1

First initiate the height array as 1 1 0 1 0 1, which is just a copy of the first row. Then we can easily calculate the max area is 2.

Then update the array. We scan the second row, when the matrix[1][i] is 0, set the height[i] to 0; else height[i] += 1, which means the height has increased by 1. So the height array again becomes 0 2 0 0 1 2. The max area now is also 2.

Apply the same method until we scan the whole matrix. the last height arrays is 2 4 2 2 0 4, so the max area has been found as 2 * 4 = 8.

Then reason we scan the whole matrix is that the maximum value may appear in any row of the height.
*/
public class Solution {
    public int maximalRectangle(char[][] matrix) {
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
        
        int result = largestArea(height);
        for(int i = 1; i < rows; i ++){
            resetHeight(matrix, height, i);
            result = Math.max(result, largestArea(height));
        }
        
        return result;
    }
    
    private void resetHeight(char[][] matrix, int[] height, int row){
        for(int i = 0; i < matrix[0].length; i++)
        {
            height[i] =matrix[row][i] == '1'? (height[i]+1):0;
        }
    }    
    
    private int largestArea(int[] height) {
        final int len = height.length;
        
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++)
        {
            int currentHeight = i < len ? height[i]: 0;
            //If stack is empty or currentHeight is higher than the bar at top of stack, then push ‘i’ to stack.
            if(s.isEmpty() || currentHeight >= height[s.peek()])
            {
                s.push(i);
            }
            // If currentHeight is smaller than the top of stack, then keep removing the top of stack while top of the stack is greater. Let
            // the removed bar be hist[tp]. Calculate area of rectangle with hist[tp] as smallest bar. For hist[tp], the ‘left index’ 
            // is previous (previous to tp) item in stack and ‘right index’ is ‘i’ (current index).
            else
            {
                final int tp = s.pop();
                // Calculate the area with height[tp] stack as smallest bar
                final int width = s.isEmpty() ? i : i - 1 - s.peek();
                maxArea = Math.max(maxArea, height[tp] * width);
                i--;
            }
        }
        return maxArea;
    }
}