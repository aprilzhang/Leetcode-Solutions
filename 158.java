/**
159. Longest Substring with At Most Two Distinct Characters
Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

For example, Given s = ¡°eceba¡±,

T is "ece" which its length is 3.
*/
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s==null||s.isEmpty())
        {
            return 0;
        }
        final Map<Character,Integer> buff = new HashMap<>();
        
        int max = 0;
        int start = 0;
        for(int i =0;i<s.length();i++)
        {
            buff.put(s.charAt(i),i);
            if(buff.size()>2)
            {
                int toRemoveLastSeen = i;
                for(int lastIndex : buff.values()) 
                {
                    toRemoveLastSeen = Math.min(toRemoveLastSeen,lastIndex);
                }
                buff.remove(s.charAt(toRemoveLastSeen));
                start = toRemoveLastSeen+1;
            }
            max = Math.max(max,i-start+1);
        }
        return max;
    }
}

//Solution that only applies to 2 distinct char case
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int charIndex1 = 0; //Index of first char
        int charIndex2 = -1; //index before second char
        int maxLen = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) 
            {
                continue;
            }
            if (charIndex2 != -1 && s.charAt(i) != s.charAt(charIndex2)) 
            {
                maxLen = Math.max(maxLen, i - charIndex1);
                charIndex1 = charIndex2 + 1;
            }
            charIndex2 = i - 1;
        }
        return Math.max( maxLen, s.length() - charIndex1);
    }
}