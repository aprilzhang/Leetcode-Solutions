//My solution TLE
public class Solution {
    public boolean isMatch(String s, String p) {
        System.out.println("s = "+s+" p = "+p);
        if(s==null||p==null)
        {
            return false;
        }
        else if(s.isEmpty()&&p.isEmpty())
        {
            return true;
        }
        else if(!s.isEmpty()&&p.isEmpty())
        {
            return false;
        }

        if(p.length()>=2&& p.charAt(1)=='*')
        {
            int i =0;
            while(i<s.length()&&(s.charAt(i)==p.charAt(0)||p.charAt(0)=='.'))//Matches zero or more
            {
                if(isMatch(s.substring(i),p.substring(2)))
                {
                    return true;
                }
                i++;
            }
            return isMatch(s.substring(i),p.substring(2));
        }
        else if(!s.isEmpty()&&(s.charAt(0)==p.charAt(0)||p.charAt(0)=='.'))
        {
            return isMatch(s.substring(1),p.substring(1));
        }
        else
        {
            return false;
        }
    }
}

//DP solution
/**
1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
3, If p.charAt(j) == '*': 
   here are two sub conditions:
               1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
               2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
                              dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a 
                           or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
                           or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
*/
public class Solution {
    public boolean isMatch(String s, String p) {
        if(s==null||p==null)
        {
            return false;
        }
        final boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) 
        {
            if (p.charAt(i) == '*' && dp[0][i-1]) 
            {
                dp[0][i+1] = true;
            }
        }
        
        for (int i = 0 ; i < s.length(); i++) 
        {
            for (int j = 0; j < p.length(); j++) 
            {
                if (p.charAt(j) == '.'||p.charAt(j) == s.charAt(i)) 
                {
                    dp[i+1][j+1] = dp[i][j];
                }
                else if (p.charAt(j) == '*') 
                {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') 
                    {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else 
                    {
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}