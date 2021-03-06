/**
308. Range Sum Query 2D - Mutable
Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
update(3, 2, 2)
sumRegion(2, 1, 4, 3) -> 10
Note:
The matrix is only modifiable by the update function.
You may assume the number of calls to update and sumRegion function is distributed evenly.
You may assume that row1 �� row2 and col1 �� col2.
*/
public class NumMatrix {
    private final int[][] rowSums;

    public NumMatrix(int[][] matrix) {
        final int nrows = matrix.length;
        if(nrows==0)
        {
            rowSums = new int[0][0];
            return;
        }
        final int ncols = matrix[0].length;
        rowSums = new int[nrows][ncols];
        for(int row = 0;row<nrows;row++)
        {
            final int[] rowData = matrix[row];
            rowSums[row][0] = rowData[0];
            for(int column = 1;column<ncols;column++)
            {
                rowSums[row][column] = rowSums[row][column-1]+rowData[column];
            }
        }
    }
    
    public void update(int row, int col, int val) {
        final int oldValue = rowSums[row][col]-(col==0?0:rowSums[row][col-1]);
        for(int i = col;i<rowSums[row].length;i++)
        {
            rowSums[row][i] = rowSums[row][i]-oldValue+val;
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int row = row1;row<=row2;row++)
        {
            sum+=(rowSums[row][col2]-(col1==0?0:rowSums[row][col1-1]));
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */