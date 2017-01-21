/¡Á¡Á
242. Valid Anagram
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
Answer:Use hashMap
¡Á/
public class Solution {
    public boolean isAnagram(String s, String t) {
        final int[] sCounts = new int[32];
        for(char c:s.toCharArray())
        {
            sCounts[((int)c-'a')] ++;
        }
        final int[] tCounts = new int[32];
        for(char c:t.toCharArray())
        {
            tCounts[((int)c-'a')] ++;
        }
        return Arrays.equals(sCounts,tCounts);
    }
}