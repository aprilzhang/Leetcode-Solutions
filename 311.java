/**
311. Sparse Matrix Multiplication
Given two sparse matrices A and B, return the result of AB.

You may assume that A's column number is equal to B's row number.

Example:

A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]


     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |
*/
public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        if(A.length==0||B.length==0)
        {
            return new int[0][0];
        }
        final int aNumberRows = A.length;
        final int aNumberColumns = A[0].length;
        final int bNumberRows = B.length;
        final int bNumberColumns = B[0].length;
        
        final int[][] result = new int[aNumberRows][bNumberColumns];
        
        for(int aRow = 0; aRow<aNumberRows;aRow++)
        {
            for(int aColumn = 0; aColumn<aNumberColumns;aColumn++)
            {
                if (A[aRow][aColumn] == 0) 
                {
                    continue;
                }
                for(int bColumn = 0; bColumn<bNumberColumns;bColumn++)
                {
                    if (B[aColumn][bColumn] == 0)
                    {
                        continue;
                    }
                    result[aRow][bColumn] += A[aRow][aColumn]*B[aColumn][bColumn];
                }
            }
        }
        return result;
    }
}