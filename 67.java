/**
67. Add Binary
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/
public class Solution {
    public String addBinary(String a, String b) {
        //as is shorter than bs
        final char[] as;
        final char[] bs;
        if(a.length()>b.length())
        {
            bs = a.toCharArray();
            as = b.toCharArray();
        }
        else
        {
            as = a.toCharArray();
            bs = b.toCharArray();
        }
        final int lengtha = as.length;
        final int lengthb = bs.length;

        final StringBuilder builder = new StringBuilder();
        int carry = 0;
        for(int i = 1;i<=lengthb;i++)
        {
            final int sum = (i>lengtha?0:(as[lengtha-i]-'0'))+(bs[lengthb-i]-'0')+carry;
            carry  = sum/2;
            builder.insert(0,sum%2);
        }
        if(carry>0||lengthb==0)
        {
            builder.insert(0,carry);
        }
        
        return builder.toString();
    }
}
//Slightly faster
public class Solution {
    public String addBinary(String a, String b) {
        final char[] as = a.toCharArray();
        final char[] bs = b.toCharArray();

        final StringBuilder builder = new StringBuilder();
        int carry = 0;
        for(int i = as.length-1,j = bs.length-1;i>=0||j>=0;)
        {
            int sum = carry;
            if(i>=0)
            {
                sum +=as[i--]-'0';
            }
            if(j>=0)
            {
                sum +=bs[j--]-'0';
            }
            carry  = sum/2;
            builder.insert(0,sum%2);
        }
        if(carry>0||builder.length()==0)
        {
            builder.insert(0,carry);
        }
        
        return builder.toString();
    }
}