/**
151. Reverse Words in a String
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".
*/
public class Solution {
    public String reverseWords(String s) {
        if(s.isEmpty())
        {
            return s;
        }
        final String[] words = s.trim().split("\\s+");
        final StringBuilder builder= new StringBuilder();
        for(int i = words.length - 1; i > 0; i--)
        {
            builder.append(words[i]).append(" ");
        }
        return builder.append(words[0]).toString();
    }
}

public String reverseWords(String s) {
    String[] words = s.trim().split("\\s+");
    Collections.reverse(Arrays.asList(words));
    return String.join(" ", words);
}