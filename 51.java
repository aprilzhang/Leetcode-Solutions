/**
51. N-Queens
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/

//My solution
//Slow! probably because the string pending
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        final List<List<String>> result = new ArrayList<>();
        final List<String> temp = new ArrayList<>();
        for(int i =0;i<n;i++)
        {
            temp.add(new String(new char[n]).replace('\0', '.'));
        }
        backtrack(result,temp,0,n );
        return result;
    }
    private void backtrack(List<List<String>> result,List<String> temp,int i, int n)
    {
        if(i==n)
        {
            result.add(new ArrayList<String>(temp));
            return;
        }
        
        for(int j = 0; j <n; j++) 
        {
            final String oldString = temp.get(i);
            if(checkCorrectness(temp,n,i,j))
            {
                temp.set(i,oldString.substring(0,j)+'Q'+oldString.substring(j+1));
                //Next row
                backtrack(result,temp,i+1,n);
                temp.set(i,oldString);
            }
        }
    }
    
    private boolean checkCorrectness(List<String> solution,int n,int row, int column)
    {
        //Check row
        int count = 0;
        for(int i =0;i<n;i++)
        {
            if(solution.get(row).charAt(i)=='Q')
            {
                return false;
            }
        }
        
        //check column
        count = 0;
        for(String r:solution)
        {
            if(r.charAt(column) =='Q')
            {
                return false;
            }
        }
        
        
        //diagonal
        final int sum = row+column;
        
        count =0;
        int lower =Math.max(0,sum+1-n); 
        int upper = Math.min(sum,n-1);
        for(int i = lower;i<=upper;i++)
        {
            if(solution.get(i).charAt(sum-i)=='Q')
            {
            return false;
            }
        }
        
        //anti diagonal
        
        final int diff = row-column;
        count =0;
        lower =Math.max(0,diff); 
        upper = Math.min(n-1,n-1+diff);
        for(int i = lower;i<=upper;i++)
        {
            if(solution.get(i).charAt(i-diff)=='Q')
            {
               return false;
            }
        }
        return true;
    }
}

//Better solution
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(board, 0, res);
        return res;
    }
    
    private void dfs(char[][] board, int colIndex, List<List<String>> res) {
        if(colIndex == board.length) {
            res.add(construct(board));
            return;
        }
        
        for(int i = 0; i < board.length; i++) {
            if(validate(board, i, colIndex)) {
                board[i][colIndex] = 'Q';
                dfs(board, colIndex + 1, res);
                board[i][colIndex] = '.';
            }
        }
    }
    
    private boolean validate(char[][] board, int x, int y) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < y; j++) {
                if(board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i))
                    return false;
            }
        }
        
        return true;
    }
    
    private List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}