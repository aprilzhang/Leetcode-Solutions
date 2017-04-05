/**
168. Excel Sheet Column Title
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
*/
public class Solution {
    public String convertToTitle(int n) {
        final StringBuilder builder = new StringBuilder();
        while(n!=0)
        {
            final int mod = (n-1)%26;
            builder.insert(0,(char)(mod +'A'));
            n = (n-1)/26;
        }
        return builder.toString();
    }
}

//One liner solution
public class Solution {
    public String convertToTitle(int n) {
        return n == 0 ? "" : convertToTitle((n-1) / 26) + (char)('A' + ((n-1) % 26));
    }
}