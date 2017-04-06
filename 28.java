/**
28. Implement strStr()
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/
public class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty())
        {
            return 0;
        }
        for(int i =0;i<=haystack.length()-needle.length();i++)
        {
            for(int j = 0;j<needle.length();j++)
            {
                if(needle.charAt(j)!=haystack.charAt(i+j))
                {
                    break;
                }
                if(j==needle.length()-1)
                {
                    return i;
                }
            }
        }
        return -1;
    }
}


//First reaction is to use KMP algorithm!
//Or Rabin-Karp