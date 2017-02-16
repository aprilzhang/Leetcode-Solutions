public class Solution {
    public List<List<String>> wordSquares(String[] words) {
        for(String word:words)
        {
            if(word.length==1)
            for(String word2:words)
            {
                if()
                for(String word3:words)
                {
                    for(String word4:words)
                    {
                        for(String word5:words)
                        {
                            
                        }   
                    } 
                }  
            }
        }
    }
    
    private static List<String> matchStrings(String word,List<String> words, int matchIndex)
    {
        final List<String> result = new ArrayList<>();
        if(word==null||word.length()==0)
        {
            return result;
        }
            result.add(word);
        if(word.length()==1)
        {
            return result;
        }
        for(int i =1;i<word.length();i++)
        {
            for(String toMatch:words)
            {
                for(int charIndex = 0;charIndex<=i;++)
                {
                    if(toMatch.charAt(charIndex)==word.charAt(i))
                }
            }
        }
    }
}