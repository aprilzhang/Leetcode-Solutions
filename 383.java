/¡Á¡Á
383. Ransom Note
Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
¡Á/
public class Solution {
    private static final int LOWERCASE_COUNT = 26;
    public boolean canConstruct(String ransomNote, String magazine) {
        final int[] ransomCharCount = countChars(ransomNote);
        final int[] magazineCharCount = countChars(magazine);
        for(int i =0;i<LOWERCASE_COUNT;i++)
        {
            if(ransomCharCount[i]>magazineCharCount[i])
            {
                return false;
            }
        }
        return true;
    }
    
    private static int[] countChars(String input)
    {
        final int[] charCount = new int[LOWERCASE_COUNT];
        for(char c:input.toCharArray())
        {
            int index = c-'a';
            charCount[index] +=1; 
        }
        return charCount;
    }
}