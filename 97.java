/**
97. Interleaving String
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
*/
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1==null||s2==null||s3==null||s1.length()+s2.length()!=s3.length())
        {
            return false;
        }
        final boolean[][] cache = new boolean[s1.length()+1][s2.length()+1];
        //if both s1 and s2 is currently empty, s3 is empty too, and it is considered interleaving
        cache[0][0] = true;
        
        // If only s2 is empty, then if previous s1 position is interleaving and current s1 position
        // char is equal to s3 current position char, it is considered interleaving
        for (int i = 1; i <= s1.length(); i++)
        {
            cache[i][0] = cache[i-1][0]&&(s1.charAt(i-1)==s3.charAt(i-1));
        }
    
        //similar idea applies to when s1 is empty
        for (int i = 1; i <= s2.length(); i++){
            cache[0][i] = cache[0][i-1]&&(s2.charAt(i-1)==s3.charAt(i-1));
        }
        
        //when both s1 and s2 is not empty, 
        //then if we arrive i, j from i-1, j, 
        //then if i-1,j is already interleaving and i and current s3 position equal, it s interleaving.
        //If we arrive i,j from i, j-1,
        //then if i, j-1 is already interleaving and j and current s3 position equal. it is interleaving
        for(int i = 1;i<=s1.length();i++)
        {
            for(int j = 1;j<=s2.length();j++)
            {
                cache[i][j] = (cache[i-1][j]&&(s1.charAt(i-1)==s3.charAt(i+j-1)))
                    || (cache[i][j-1]&&(s2.charAt(j-1)==s3.charAt(i+j-1)));
            }
        }
        
        return cache[s1.length()][s2.length()];
    }
}