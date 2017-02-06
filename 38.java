/**
38. Count and Say
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
*/
public class Solution {
    public String countAndSay(int n) {
        String result = "1";
        for(int i =1; i<n;i++)
        {
            result = countAndSay(result);
        }
        return result;
    }
    
    private static String countAndSay(String nString)
    {
        final StringBuilder builder = new StringBuilder();
        int i = 0;
        while(i<nString.length())
        {
            final int digit = nString.charAt(i)-'0';
            int count = 1;
            i++;
            while(i<nString.length()&&(nString.charAt(i)-'0')==digit)
            {
                i++;
                count++;
            }
            builder.append(count).append(digit);
        }
        return builder.toString();
    }
}