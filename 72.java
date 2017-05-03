/**
72. Edit Distance
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
*/
public class Solution {
    //cost(i, j) := minimum cost (or steps) required to convert first i characters of word1 to first j characters of word2
    public int minDistance(String word1, String word2) {
        final int m = word1.length();
        final int n = word2.length();
        
        final int[][] cost = new int[m + 1][n + 1];
        
        //cost(0, k) = cost(k, 0) = k
        for(int i = 0; i <= m; i++)
            cost[i][0] = i;
        for(int i = 1; i <= n; i++)
            cost[0][i] = i;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                //Case 1: word1[i] == word2[j], i.e. the ith the jth character matches.
                //cost(i, j) = cost(i - 1, j - 1)
                if(word1.charAt(i) == word2.charAt(j))
                    cost[i + 1][j + 1] = cost[i][j];
                //Case 2: word1[i] != word2[j], then we must either insert, delete or replace, whichever is cheaper
                //cost(i, j) = 1 + min { cost(i, j - 1), cost(i - 1, j), cost(i - 1, j - 1) }
                //cost(i, j - 1) represents insert operation
                //cost(i - 1, j) represents delete operation
                //cost(i - 1, j - 1) represents replace operation
                else {
                    int a = cost[i][j];
                    int b = cost[i][j + 1];
                    int c = cost[i + 1][j];
                    cost[i + 1][j + 1] = 1+Math.min(a, Math.min(b,c));
                }
            }
        }
        return cost[m][n];
    }
}