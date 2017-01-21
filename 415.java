/**
415. Add Strings
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/
public class Solution {
    public String addStrings(String num1, String num2) {
        final int length1 = num1.length();
        final int length2 = num2.length();
        final StringBuilder builder = new StringBuilder();
        for(int i = length1-1, j = length2-1,carry = 0;i >= 0 || j >= 0 || carry == 1;i--,j--)
        {
            final int digit1 = i < 0 ? 0:num1.charAt(i)-'0';
            final int digit2 =j < 0 ? 0 : num2.charAt(j)-'0';
            final int sum = digit1+digit2+carry;
            builder.insert(0,sum%10);
            carry = sum/10;
        }
        return builder.toString();
    }
}