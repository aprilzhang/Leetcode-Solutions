/**
438. Find All Anagrams in a String
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
*/
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        final int pLength = p.length();
        final int[] pChars = new int[26];
        for(int i =0;i<pLength;i++)
        {
            pChars[p.charAt(i)-'a']++;
        }
        
        final List<Integer> result = new ArrayList<>();
        
        final int[] windowChars = new int[26];
        int diff = pLength;
        for(int i =0;i<s.length();i++)
        {
            final int c = s.charAt(i)-'a';
            windowChars[c]++;
            diff+=windowChars[c]>pChars[c]?1:-1;
            if(i>=pLength)
            {
                final int cToRemove = s.charAt(i-pLength)-'a';
                windowChars[cToRemove]--;
                diff+=pChars[cToRemove]>windowChars[cToRemove]?1:-1;
            }
            if(diff == 0)
            {
                result.add(i-pLength+1);
            }
        }
        return result;
    }
}