/**
3. Longest Substring Without Repeating Characters
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int count = 0;
        int lastRepearIndex = -1;
        Map<Character,Integer> lastIndexes = new HashMap<>();
        for(int i =0; i<s.length();i++)
        {
            final char c = s.charAt(i);
            if(lastIndexes.containsKey(c))//repeat
            {
                max = Math.max(count,max);
                lastRepearIndex = Math.max(lastRepearIndex,lastIndexes.get(c));
                count = i-lastRepearIndex;
            }
            else
            {
                count++;
            }
            lastIndexes.put(c,i);
        }
        return Math.max(count,max);
    }
}