/**
140. Word Break II
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. You may assume the dictionary does not contain duplicate words.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
*/
//My solution TLE
public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        if(s==null||wordDict==null)
        {
            return new ArrayList<>();
        }
        if(s.isEmpty())
        {
            return Arrays.asList("");
        }
        final List<String> result = new ArrayList<>();
        backtrack(result,wordDict,s,0,1);
        return result;
    }
    
    private void backtrack(List<String> result,List<String> wordDict, String temp, int fromIndex, int toIndex)
    {
        for(int i = toIndex;i<=temp.length();i++)
        {
            if(wordDict.contains(temp.substring(fromIndex,i)))
            {
                if(i<temp.length())
                {
                    final String newTemp = temp.substring(0,i)+" "+temp.substring(i);
                    backtrack(result,wordDict,newTemp,i+1,i+2);
                }
                else
                {
                    result.add(temp);
                }
            }
        }
    }
}

//Correct solution
public List<String> wordBreak(String s, Set<String> wordDict) {
    return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
}       

// DFS function returns an array including all substrings derived from s.
List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>>map) {
    if (map.containsKey(s)) 
        return map.get(s);
        
    LinkedList<String>res = new LinkedList<String>();     
    if (s.length() == 0) {
        res.add("");
        return res;
    }               
    for (String word : wordDict) {
        if (s.startsWith(word)) {
            List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
            for (String sub : sublist) 
                res.add(word + (sub.isEmpty() ? "" : " ") + sub);               
        }
    }       
    map.put(s, res);
    return res;
}