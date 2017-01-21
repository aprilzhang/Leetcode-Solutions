/¡Á¡Á
409. Longest Palindrome
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
¡Á/
public class Solution {
    public int longestPalindrome(String s) {
        final int[] counts = new int[128];
        for(char c:s.toCharArray())
        {
            counts[((int)c-'A')]++;
        }
        int length = 0;
        boolean odd = false;
        for(int count:counts)
        {
            if(count%2==0)
            {
                length+=count;
            }
            else if(!odd)
            {
                length+=count;
                odd=true;
            }
            else if(count>0)
            {
               length+=count-1; 
            }
        }
        return length;
    }
}