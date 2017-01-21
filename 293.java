/**
293. Flip Game
You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to compute all possible states of the string after one valid move.

For example, given s = "++++", after one move, it may become one of the following states:

[
  "--++",
  "+--+",
  "++--"
]
If there is no valid move, return an empty list []
*/
public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        final List<String> nextMoves = new ArrayList<>();
        if(s.length()<=1)
        {
            return nextMoves;
        }
        final char[] input = s.toCharArray();
        for(int i = 0;i<input.length-1;i++)
        {
            if(input[i]=='+'&&input[i+1]=='+')
            {
                final String nextMove = new StringBuilder(s).replace(i,i+2,"--").toString();
                nextMoves.add(nextMove);
            }
        }
        return nextMoves;
    }
}