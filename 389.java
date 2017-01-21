/**
389. Find the Difference
Given two strings s and t which consist of only lowercase letters.

String t is generated by random shuffling string s and then add one more letter at a random position.

Find the letter that was added in t.

Example:

Input:
s = "abcd"
t = "abcde"

Output:
e

Explanation:
'e' is the letter that was added.
*/
//Another solution is to make use of lowercase letters.
//Store a 26 bit integer, checker ^= 1<<char, the one left 1 should be the char.
public class Solution {
    public char findTheDifference(String s, String t) {
        int checker = 0;
        for(char schar:s.toCharArray())
        {
            checker ^= schar;
        }
        for(char tchar:t.toCharArray())
        {
            checker ^= tchar;
        }
        return (char)checker;
    }
}