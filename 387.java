/¡Á¡Á
387. First Unique Character in a String
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
¡Á/
public class Solution {
    public int firstUniqChar(String s) {
        final int[] charIndex = new int[26];
        for(int i =0;i<26;i++)
        {
            charIndex[i] =-1;
        }
        final char[] chars = s.toCharArray();
        //Record unique char indexes, chars appeared more than once is -2.
        for(int index =0;index<chars.length;index++)
        {
            final int charInt = chars[index]-'a';
            charIndex[charInt] = charIndex[charInt]==-1?index:-2;
        }
        //Find the minimun non-negative index;
        int min = -1;
        for(int c:charIndex)
        {
            if(c>=0)
            {
                min = min==-1?c:Math.min(min,c);
            }
        }
        return min;
    }
}