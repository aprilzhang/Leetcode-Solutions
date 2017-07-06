/**
161. One Edit Distance
Given two strings S and T, determine if they are both one edit distance apart.
*/
public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s==null||t==null||Math.abs(s.length()-t.length())>1)
        {
            return false;
        }
        
        if(s.length()>t.length())
        {
            final String temp = s;
            s= t;
            t= temp;
        }
        boolean diffLength = s.length()<t.length();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)!=t.charAt(i))
            {
                return diffLength
                    ?s.substring(i).equals(t.substring(i+1))
                    :s.substring(i+1).equals(t.substring(i+1));
            }
        }
        
        return diffLength;
    }
}