/**
340. Longest Substring with At Most K Distinct Characters
Given a string, find the length of the longest substring T that contains at most k distinct characters.

For example, Given s = “eceba” and k = 2,

T is "ece" which its length is 3.
*/
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        final Map<Character, Integer> charAppearIndex = new HashMap<>();
        int maxLength = 0;
        int leastRecentCharIndex = 0;
        for(int i =0;i<s.length();i++)
        {
            charAppearIndex.put(s.charAt(i),i);
            if(charAppearIndex.size()>k)
            {
                maxLength = Math.max(maxLength,i-leastRecentCharIndex);
                
                leastRecentCharIndex = i;
                for(char c: charAppearIndex.keySet())
                {
                    leastRecentCharIndex = Math.min(leastRecentCharIndex,charAppearIndex.get(c));
                }
                charAppearIndex.remove(s.charAt(leastRecentCharIndex));
                leastRecentCharIndex++;
            }
        }
        return Math.max(maxLength,s.length()-leastRecentCharIndex);
    }
}

//faster solution
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        final int[] count = new int[256];
        int windowSize = 0;
        int i = 0;
        int maxLength = 0;
        for (int j = 0; j < s.length(); j++) {
            if ( count[s.charAt(j)] == 0)
            {
                windowSize++;
            }
            count[s.charAt(j)]++;
            
            if (windowSize > k) { 
                
                while ( --count[s.charAt(i++)]> 0);
                
                windowSize--;
            }
            maxLength = Math.max(maxLength, j - i+1);
        }
        return maxLength;
    }
}