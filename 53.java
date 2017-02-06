/**
Maximum Subarray
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/
public class Solution {
    public int maxSubArray(int[] nums) {
        int max_end_here= 0;
        int max_so_far = Integer.MIN_VALUE;
        for(int i =0;i<nums.length;i++)
        {
            max_end_here = Math.max(nums[i],max_end_here+nums[i]);
            max_so_far = Math.max(max_so_far,max_end_here);
        }
        return max_so_far;
    }
}