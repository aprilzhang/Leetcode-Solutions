/**
200. Number of Islands
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
*/
public class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0)
        {
            return 0;
        }
        final int numRows = grid.length;
        final int numColumns = grid[0].length;
        
        final int[] roots = new int[numRows*numColumns];
        for(int cellIndex =0;cellIndex<roots.length;cellIndex++)
        {
            roots[cellIndex] = cellIndex;
        }
        
        int count = 0;
        for(int rowIndex = 0; rowIndex<numRows;rowIndex++)
        {
            for(int colIndex = 0; colIndex<numColumns;colIndex++)
            {
                final int currentRoot = rowIndex*numRows+colIndex;
                if(markRoot(grid,roots,rowIndex,colIndex,numRows,numColumns,currentRoot))
                {
                    count++;
                }
            }
        }
        return count;
    }
    
    private static boolean markRoot(char[][] grid, int[] roots, int row, int column, int numRows,int numColumns, int root)
    {
        if(grid[row][column] == '0')
        {
            return false;
        }
        final int cellIndex = row*numColumns+column;
        if(roots[cellIndex]!=cellIndex) //have been marked
        {
            return false;
        }
        roots[cellIndex] = root;
        if(row>0)
        {
         markRoot(grid,roots,row-1,column,numRows,numColumns,root);   
        }
        if(column>0)
        {
            markRoot(grid,roots,row,column-1,numRows,numColumns,root);
        }
        if(column+1<numColumns)
        {
            markRoot(grid,roots,row,column+1,numRows,numColumns,root);
        }
        if(row+1<numRows)
        {
            markRoot(grid,roots,row+1,column,numRows,numColumns,root);
        }
        return true;
    }
}

//Same algorithm, but a bit faster
public class Solution {

    private int n;
    private int m;
    
    public int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j);
                    ++count;
                }
        }    
        return count;
    }
    
    private void DFSMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
        grid[i][j] = '0';
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }
}