/**
58. Length of Last Word
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
*/
public class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length()-1;
        while(i>=0&& s.charAt(i)==' ')
        {
            i--;
        }
        int count = 0;
        while(i>=0&& s.charAt(i)!=' ')
        {
           count++; 
           i--;
        }
        return count;
    }
}

//Shorter but slower solution
public class Solution {
    public int lengthOfLastWord(String s) {
        final String trimmed = s.trim();
        return trimmed.length()-trimmed.lastIndexOf(" ")-1;
    }
}