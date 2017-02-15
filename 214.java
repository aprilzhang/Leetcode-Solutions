/**
214. Shortest Palindrome
Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

For example:

Given "aacecaaa", return "aaacecaaa".

Given "abcd", return "dcbabcd".
*/
public class Solution {
    public String shortestPalindrome(String s) {
        if(s==null||s.length()<2)
        {
            return s;
        }
        final int mid = s.length()/2;
        for(int i =mid;i>=0;i--)
        {
            if(canBecomePalindrome(s,i,i))
            {
                return new StringBuilder(s.substring(2*i+1)).reverse().append(s).toString();
            }
            if(i>0&&canBecomePalindrome(s,i-1,i))
            {
                return new StringBuilder(s.substring(2*i)).reverse().append(s).toString();
            }
        }
        return "";
    }
    
    private static boolean canBecomePalindrome(String s, int j, int k)
    {
        while(j>=0&&k<s.length()&&s.charAt(j)==s.charAt(k))
        {
            j--;
            k++;
        }
        return j<0;
    }
}

//Best solution
//example:c a t a c b # b c a t a c
//        0 0 0 0 1 0 0 0 1 2 3 4 5
public class Solution {
    public String shortestPalindrome(String s) {
        final String temp = s + "#" + new StringBuilder(s).reverse().toString();
        
        //KMP table
        final int[] table = getKMPTable(temp);
        
        //get the maximum palin part in s starts from 0
        return new StringBuilder(s.substring(table[table.length - 1])).reverse().toString() + s;
    }
    
    public int[] getKMPTable(String s){
        //get lookup table
        final int[] table = new int[s.length()];
        
        //pointer that points to matched char in prefix part
        int index = 0;
        
        //skip index 0, we will not match a string with itself
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(index) == s.charAt(i)){
                //we can extend match in prefix and postfix
                table[i] = table[i-1] + 1;
                index ++;
            }
            else//match failed, we try to match a shorter substring
            {
                //by assigning index to table[i-1], we will shorten the match string length, and jump to the 
                //prefix part that we used to match postfix ended at i - 1
                index = table[i-1];
                
                while(index > 0 && s.charAt(index) != s.charAt(i))
                {
                    //we will try to shorten the match string length until we revert to the beginning of match (index 1)
                    index = table[index-1];
                }
                
                //when we are here may either found a match char or we reach the boundary and still no luck
                //so we need check char match
                if(s.charAt(index) == s.charAt(i)){
                    //if match, then extend one char 
                    index ++ ;
                }
                
                table[i] = index;
            }
            
        }
        
        return table;
    }
}