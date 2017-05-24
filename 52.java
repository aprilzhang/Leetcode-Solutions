/**
52. N-Queens II
Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.
*/
public class Solution {
    public int totalNQueens(int n) {
        final boolean[] column = new boolean[n];
        final boolean[] diagonal = new boolean[2*n-1];
        final boolean[] antiDiagonal = new boolean[2*n-1];
        return backtrack(column,diagonal,antiDiagonal,0,n);
    }
    
    private int backtrack(final boolean[] column,final boolean[] diagonal,final boolean[] antiDiagonal,int row, int n)
    {
        if(row==n)
        {
            return 1;
        }
        int count = 0;
        for(int j = 0;j<n;j++)
        {
            if(!column[j]&&!diagonal[row+j]&&!antiDiagonal[row-j+n-1])
            {
                column[j]=true;
                diagonal[row+j] = true;
                antiDiagonal[row-j+n-1]= true;
                
                count+=backtrack(column,diagonal,antiDiagonal,row+1,n);
                
                column[j]=false;
                diagonal[row+j] = false;
                antiDiagonal[row-j+n-1]= false;
            }
        }
        return count;
    }
}