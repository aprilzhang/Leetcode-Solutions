/**
198. House Robber
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/
//My solution is faster
public class Solution {
    public int rob(int[] nums) {
        final int length = nums.length;
        final int[] max = new int[length]; 
        for(int i = 0; i<length;i++)
        {
            if(i<2)
            {
                max[i] = nums[i];
            }
            else if (i==2)
            {
                max[i] = max[i-2]+nums[i];
            }
            else
            {
                max[i] = Math.max(max[i-3],max[i-2])+nums[i];
            }
        }
        
        if(length==0)
        {
            return 0;
        }
        if(length == 1)
        {
             return nums[0];
        }
        return Math.max(max[length-1],max[length-2]);
    }
}
//O(1) space soluton
public class Solution {
    public int rob(int[] nums) {
        int prevNo = 0;
        int prevYes = 0;
        for(int i = 0; i<nums.length;i++)
        {
            int temp = prevNo;
            prevNo  = Math.max(prevNo,prevYes) ;
            prevYes = temp+nums[i];
        }
        return Math.max(prevNo,prevYes);
    }
}