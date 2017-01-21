/**
136. Single Number
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/
public class Solution {
    public int singleNumber(int[] nums) {
        int checker = 0;
        for(int num:nums)
        {
            checker ^= num;
        }
        return checker;
    }
}