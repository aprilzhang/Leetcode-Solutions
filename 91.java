/**
91. Decode Ways
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2
*/
public class Solution {

    public int numDecodings(String s) {
        final String numberString = s.replaceAll("[^\\d.]", "");
        final int length = numberString.length();
        if(length==0)
        {
            return 0;
        }
        final int[] counts = new int[length+1];
        counts[length] = 1;
        for(int i = length-1;i>=0;i--)
        {
            if(numberString.charAt(i)!='0')
            {
                counts[i] += counts[i+1];
            }
            if(i+2 <=length )
            {
                final int nextTwo = Integer.parseInt(numberString.substring(i,i+2));
                if(nextTwo>=10&&nextTwo<=26)
                {
                    counts[i]+=counts[i+2];
                }
            }
        }
        return counts[0];
    }
}