/**
115. Distinct Subsequences
Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
*/
public class Solution {
    public int numDistinct(String s, String t) {
        if(s==null||t==null)
        {
            return 0;
        }
		
		//cache[i][j] means start from ith char in s and jth char in t.
        int[][] cache = new int[s.length()+1][t.length()+1];
        
        
        cache[s.length()][t.length()] = 1;
        
        for(int i = s.length()-1;i>=0;i--)
        {
            cache[i][t.length()] = 1;
            for(int j = t.length()-1;j>=0;j--)
            {
                cache[i][j] = cache[i+1][j];
                if(s.charAt(i)==t.charAt(j))
                {
                    cache[i][j]+=cache[i+1][j+1];
                }
            } 
        }
        
        return cache[0][0];
    }
}