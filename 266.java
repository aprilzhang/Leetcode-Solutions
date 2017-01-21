/**
266. Palindrome Permutation
Given a string, determine if a permutation of the string could form a palindrome.

For example,
"code" -> False, "aab" -> True, "carerac" -> True.
*/
public class Solution {
    public boolean canPermutePalindrome(String s) {
        final Map<Character,Integer> charMap = new HashMap<>();
        for(char c:s.toCharArray())
        {
            final Integer count = charMap.get(c);
            charMap.put(c, count==null?1:(count+1));
        }
        //Allow one char to have odd count if the string is odd length
        int oddCountChar = s.length()%2==0?0:1;
        for(int count:charMap.values())
        {
            if( count%2 ==1)
            {
                if(oddCountChar==0)
                {
                    return false;
                }
                oddCountChar--;
            }
        }
        return true;
    }
}