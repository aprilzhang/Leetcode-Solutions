/**
Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".
*/
public class Solution {
    public String reverseString(String s) {
        final char[] chars = s.toCharArray();
        final char[] reverted = new char[chars.length];
        for(int i = 0; i<chars.length;i++)
        {
            reverted[i] = chars[chars.length-1-i];
        }
        return new String(reverted);
    }
}