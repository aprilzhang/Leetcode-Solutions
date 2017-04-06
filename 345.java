/**
345. Reverse Vowels of a String
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y".
*/
public class Solution {
    private static final List<Character> VOWELS = Arrays.asList('a','e','i','o','u');
    public String reverseVowels(String s) {
        char[] origin = s.toCharArray();
        char[] after = s.toCharArray();
        int j = s.length()-1;
        for(int i =0;i<s.length();i++)
        {
            if(VOWELS.contains(Character.toLowerCase(origin[i])))
            {
                while(!VOWELS.contains(Character.toLowerCase(after[j])))
                {
                    j--;
                }
                after[j] = origin[i];
                j--;
            }
        }
        return new String(after);
    }
}

//Faster solution
public class Solution {
    private static final List<Character> VOWELS = Arrays.asList('a','e','i','o','u','A','E','I','O','U');
    public String reverseVowels(String s) {
        
        final char[] chars = s.toCharArray();
        
        int i = 0;
        int j = s.length()-1;
        while(i<j)
        {
            while(i<j&&!VOWELS.contains(chars[i]))
            {
                i++;
            }
            while(i<j&&!VOWELS.contains(chars[j]))
            {
                j--;
            }
            
            final char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;    
            
            i++;
            j--;
        }
        return new String(chars);
    }
}