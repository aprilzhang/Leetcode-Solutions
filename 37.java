/**
37. Sudoku Solver
Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.
*/
public class Solution {
    public void solveSudoku(char[][] board) {
        if(board==null||board.length!=9||board[0].length!=9)
        {
            return;
        }
        
        backtrack(board, 0,0);
    }
    
    private boolean backtrack(char[][] board, int i, int j)
    {
        if(i==9)
        {
            return true;
        }
        else if(j==9)
        {
            return backtrack(board,i+1,0);
        }
        else if(board[i][j]!='.')
        {
            return backtrack(board,i,j+1);
        }
        
        for(char value = '1';value<='9';value++)
        {
            if(checkCorrectness(board,i,j,value))
            {
                board[i][j] = value;
                if(backtrack(board,i, j+1))
                {
                    return true;
                }
                else
                {
                    board[i][j] = '.';
                }
            }
        }
        
        return false;
    }
    
    private boolean checkCorrectness(char[][] board, int i, int j, char value)
    {
        //column
        for(int x = 0; x<9;x++)
        {
            if(x!=i&&board[x][j]==value)
            {
                return false;
            }
        }
        //row
        for(int y = 0; y<9;y++)
        {
            if(y!=j&&board[i][y]==value)
            {
                return false;
            }
        }       
        //cube
        final int cubeI = i / 3;
        final int cubeJ = j / 3;
        for(int x = cubeI*3; x<cubeI*3+3;x++)
        {
            for(int y = cubeJ*3; y<cubeJ*3+3;y++)
            {
                if(x!=i&&y!=j&&board[x][y]==value)
                {
                    return false;
                }
            }  
        }
        return true;
    }
}