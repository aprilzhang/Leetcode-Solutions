/**
214. Shortest Palindrome
Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

For example:

Given "aacecaaa", return "aaacecaaa".

Given "abcd", return "dcbabcd".
*/
public class Solution {
    public String shortestPalindrome(String s) {
        if(s==null||s.length()<2)
        {
            return s;
        }
        final int mid = s.length()/2;
        for(int i =mid;i>=0;i--)
        {
            if(canBecomePalindrome(s,i,i))
            {
                return new StringBuilder(s.substring(2*i+1)).reverse().append(s).toString();
            }
            if(i>0&&canBecomePalindrome(s,i-1,i))
            {
                return new StringBuilder(s.substring(2*i)).reverse().append(s).toString();
            }
        }
        return "";
    }
    
    private static boolean canBecomePalindrome(String s, int j, int k)
    {
        while(j>=0&&k<s.length()&&s.charAt(j)==s.charAt(k))
        {
            j--;
            k++;
        }
        return j<0;
    }
}