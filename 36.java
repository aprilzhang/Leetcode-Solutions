/**
36. Valid Sudoku
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
*/

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i<9; i++){
            HashSet<Character> rows = new HashSet<Character>();
            HashSet<Character> columns = new HashSet<Character>();
            HashSet<Character> cube = new HashSet<Character>();
            for (int j = 0; j < 9;j++){
                if(board[i][j]!='.' && !rows.add(board[i][j]))
                    return false;
                if(board[j][i]!='.' && !columns.add(board[j][i]))
                    return false;
                int RowIndex = 3*(i/3);
                int ColIndex = 3*(i%3);
                if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
                    return false;
            }
        }
        return true;
    }
}

//my failed solution
//[".87654321","2........","3........","4........","5........","6........","7........","8........","9........"]
//Why this should return true?
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board==null)
        {
            return false;
        }
        return backtracking(board,0,0);
    }
    
    private static boolean backtracking(char[][] board, int row, int column)
    {
        if(column==9)
        {
            return backtracking(board,row+1,0);
        }
        else if(row==9)
        {
            return true;
        }
        
        if(board[row][column]!='.')
        {
            char temp = board[row][column];
            board[row][column]='.';
            if(!checkValid(board,row,column,temp))
            {
                return false;
            }
            board[row][column]=temp;
            return backtracking(board,row,column+1);
        }
        
        for(char i ='1';i<='9';i++)
        {
            if(checkValid(board,row,column,i))
            {
                board[row][column]=i;
                if(backtracking(board,row,column+1))
                {
                    return true;
                }
                else
                {
                    board[row][column]='.';
                }
            }
        }
        return false;
    }
    
    private static boolean checkValid(char[][] board, int row, int column, char number)
    {
        for( int i = 0;i<9;i++)
        {
            if(board[i][column]==number)
            {
                return false;
            }
        }        
        for( int j = 0;j<9;j++)
        {
            if(board[row][j]==number)
            {
                return false;
            }
        }
        final int blockStartI = row/3*3;
        final int blockStartJ = column/3*3;
        for(int i =blockStartI;i<blockStartI+3;i++)
        {
            for(int j =blockStartJ;j<blockStartJ+3;j++)
            {
               if(board[i][j]==number)
                {
                    return false;
                } 
            }
        }
        return true;
    }
}