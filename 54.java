/**
54. Spiral Matrix
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        final List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length==0 || matrix[0].length == 0)
        {
            return result;
        }
        final int rows = matrix.length;
        final int columns = matrix[0].length;
        int circle = 0;
        int i =0;
        int j =0;
        while(i>=0&&i<rows-circle&&j>=0&&j<columns-circle)
        {
            result.add(matrix[i][j]);
            if(i == circle &&j < columns-circle-1)
            {
                j++;
            }
            else if(i < rows-circle-1 && j == columns-circle-1)
            {
                i++;
            }
            else if(i>circle && i == rows-circle-1 &&j >circle )
            {
                j--;
            }
            else if(i> circle && j == circle&&j<columns-circle-1)
            {
                if(i == circle +1)
                {
                    circle++;
                    j++;
                }
                else
                {
                    i--;
                }
            }
            else
            {
                return result; //In the odd case
            }
        }
        return result;
    }
}

// faster solution
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        final List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length==0 || matrix[0].length == 0)
        {
            return result;
        }
        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j ++) {
                result.add(matrix[rowBegin][j]);
            }
            rowBegin++;
            
            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j ++) {
                result.add(matrix[j][colEnd]);
            }
            colEnd--;
            
            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j --) {
                    result.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;
            
            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j --) {
                    result.add(matrix[j][colBegin]);
                }
            }
            colBegin ++;
        }
        return result;
    }
}