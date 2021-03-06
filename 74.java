/**
74. Search a 2D Matrix
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0|| matrix[0].length == 0)
        {
            return false;
        }
        
        final int rows = matrix.length;
        final int columns = matrix[0].length;
        int a = 0;
        int b = rows*columns-1;
        
        while(a<b)
        {
            final int mid = (a+b)/2;
            final int midRow = mid/columns;
            final int midColumn = mid%columns;
            if(matrix[midRow][midColumn]==target)
            {
                return true;
            }
            else if(matrix[midRow][midColumn]<target)
            {
                a = mid+1;
            }
            else
            {
                b = mid;
            }
        }
        return matrix[a/columns][a%columns]==target;
    }
}