/**
79. Word Search
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/

public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board==null||word==null)
        {
            return false;
        }
        if(board.length==0||board[0].length==0)
        {
            return word.isEmpty();
        }
        final int rows = board.length;
        final int columns = board[0].length;
        
        //Find first letter
        for(int i = 0;i<rows;i++)
        {
            for(int j = 0;j<columns;j++)
            {
                if(board[i][j]!=word.charAt(0))
                {
                    continue;
                }
                if(backtrack(board,new boolean[rows][columns],rows,columns,i,j,0,word))
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean backtrack(char[][] board,boolean visited[][], int rows, int columns,
        int startI,int startJ,int index, String word)
    {
        if(visited[startI][startJ])
        {
            return false;
        }
        if(index==word.length()-1)
        {
            return true;
        }
        
        visited[startI][startJ] = true; 
        
        boolean found = false;
        if(startI+1<rows&&board[startI+1][startJ]==word.charAt(index+1))
        {
           found = found || backtrack(board,visited,rows,columns,startI+1,startJ,index+1,word);
        }        
        if(startI-1>=0&&board[startI-1][startJ]==word.charAt(index+1))
        {
           found = found || backtrack(board,visited,rows,columns,startI-1,startJ,index+1,word);
        }        
        if(startJ+1<columns&&board[startI][startJ+1]==word.charAt(index+1))
        {
            found = found || backtrack(board,visited,rows,columns,startI,startJ+1,index+1,word);
        }        
        if(startJ-1>=0&&board[startI][startJ-1]==word.charAt(index+1))
        {
            found = found || backtrack(board,visited,rows,columns,startI,startJ-1,index+1,word);
        }
        
        visited[startI][startJ] = false; 
        return found;
    }
    
}

//Slightly improved solution
//To save memory I decuded to apply bit mask for every visited cell. Please check board[y][x] ^= 256
public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board==null||word==null)
        {
            return false;
        }
        if(board.length==0||board[0].length==0)
        {
            return word.isEmpty();
        }
        
        final int rows = board.length;
        final int columns = board[0].length;
        
        //Find first letter
        for(int i = 0;i<rows;i++)
        {
            for(int j = 0;j<columns;j++)
            {
                if(backtrack(board,rows,columns,i,j,0,word))
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean backtrack(char[][] board,int rows, int columns,
        int i,int j,int index, String word)
    {
        if(index==word.length())
        {
            return true;
        }
        if (i<0 || j<0 || i == rows || j == columns || board[i][j] != word.charAt(index))
        {
            return false;
        }
        
	    board[i][j] ^= 256;
        
        boolean found = backtrack(board,rows,columns,i+1,j,index+1,word)
                || backtrack(board,rows,columns,i-1,j,index+1,word)
                || backtrack(board,rows,columns,i,j+1,index+1,word)
                || backtrack(board,rows,columns,i,j-1,index+1,word);
        
	    board[i][j] ^= 256;
        return found;
    }
    
}