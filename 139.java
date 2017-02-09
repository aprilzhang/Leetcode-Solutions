/**
139. Word Break
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.contains(s))
        {
            return true;
        }        
        
        boolean[] containsSubString = new boolean[s.length() + 1];
        
        containsSubString[0] = true;
        
        //Second DP
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(containsSubString[j] && dict.contains(s.substring(j, i))){
                    containsSubString[i] = true;
                    break;
                }
            }
        }
        
        return containsSubString[s.length()];
    }
}