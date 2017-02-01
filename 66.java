/**
66. Plus One
Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.
*/
public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i = digits.length-1;i>=0&&carry>0;i--)
        {
            final int sum = digits[i]+carry;
            digits[i] = sum%10;
            carry = sum/10;
        }
        if(carry==1)
        {
            final int[] newDigits = new int[digits.length+1];
            newDigits[0] = 1;
            return newDigits;
        }
        return digits;
    }
}