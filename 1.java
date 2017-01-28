/**
1. Two Sum
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        final Map<Integer, Integer> swapNums = new HashMap<>();
        for(int i = 0; i<nums.length;i++)
        {
            final int diff = target-nums[i];
            final Integer another = swapNums.get(diff);
            if(another!=null)
            {
                return new int[]{another,i};
            }
            swapNums.put(nums[i],i);
        }
        return null;
    }
}