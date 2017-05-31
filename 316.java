/**
316. Remove Duplicate Letters
Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Example:
Given "bcabc"
Return "abc"

Given "cbacdcbc"
Return "acdb"
*/

//Use stack
//I was almost there. The key is to keep the count of chars
public class Solution {
    public String removeDuplicateLetters(String s) 
    {
        final int[] res = new int[26]; //number of occurences of character (i+'a')
        
        for(int i =0;i<s.length();i++)
        {   
            res[s.charAt(i)-'a']++;
        }
        
        final boolean[] visited = new boolean[26];
        final Stack<Character> stack = new Stack<>();
        for(int i =0;i<s.length();i++)
        {
            final char c = s.charAt(i);
            //decrement number of characters remaining in the string to be analysed
            res[c-'a']--;
            //if character is already present in stack, dont bother
            if(visited[c-'a'])
            {
                continue;
            }
                
            //if current character is smaller than last character in stack which occurs later in the string again
            //it can be removed and  added later 
            // e.g stack = bc remaining string abc then a can pop b and then c
            while(!stack.empty()&&c<stack.peek()&&res[stack.peek()-'a']!=0)//better
            {
               visited[stack.pop()-'a'] = false; 
            }
            
            stack.push(c);
            visited[c-'a'] = true;
        }
        
        final StringBuilder builder = new StringBuilder();
        while(!stack.empty())
        {
            builder.insert(0,stack.pop());
        }
        
        return builder.toString();
    }
}

//Shorter but slower solution. This does not use stack.
public class Solution {
    public String removeDuplicateLetters(String s) {
        if(s==null)
        {
            return null;
        }
        if(s.isEmpty())
        {
            return "";
        }
        
        final int[] counts = new int[26];
        for(int i =0;i<s.length();i++)
        {
            counts[s.charAt(i)-'a']++;
        }
        
        int pos = 0;
        for(int i =0;i<s.length();i++)
        {
            if(s.charAt(i)<s.charAt(pos))//Find the lowest char
            {
                pos = i;
            }
            if(--counts[s.charAt(i)-'a']==0)//If this char only appear once, need to catch this oppotunity then.
            {
                break;
            }
        }
        
        return  s.charAt(pos)+removeDuplicateLetters(s.substring(pos+1).replaceAll("" + s.charAt(pos), ""));
    }
}