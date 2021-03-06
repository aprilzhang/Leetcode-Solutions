/**
15. 3Sum
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        final List<List<Integer>> result = new ArrayList<>();
        for(int i =0;i<nums.length-2;i++)
        {
            if(i > 0 && nums[i] == nums[i-1])
            {
                continue;
            }
            int start = i+1;
            int end = nums.length-1;
            while(start<end)
            {
                final int sum = nums[i]+nums[start]+nums[end];
                if(sum==0)
                {
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    do
                    {
                        start++;
                    }
                    while (start<end && nums[start] == nums[start-1]);
                    do
                    {
                        end--;
                    }
                    while (start<end && nums[end] == nums[end+1]);
                }
                else if(sum>0)
                {
                    end--;
                }
                else
                {
                    start++;
                }
            }
        }
        return result;
    }
}