/**
16. 3Sum Closest
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/
//TLE
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diffTarget = Integer.MAX_VALUE;
        for(int i = 0;i<nums.length;i++)
        {
            int lower = i+1;
            int upper = nums.length-1;
            while(lower<upper)
            {
                final int sum = nums[i]+nums[lower]+nums[upper];
                if(sum==target)
                {
                    return sum;
                }
                else 
                {
                    if(Math.abs(sum-target)<Math.abs(diffTarget))
                    {
                        diffTarget = target-sum;
                    }
                    if(sum>target)
                    {
                        upper--;
                    }
                    else
                    {
                        lower++;
                    }
                }
            }
        }
        return target-diffTarget;
    }
}
//Tinny modification Skip duplicated ones
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diffTarget = Integer.MAX_VALUE;
        for(int i = 0;i<nums.length-2;i++)
        {
            int lower = i+1;
            int upper = nums.length-1;
            while(lower<upper)
            {
                final int sum = nums[i]+nums[lower]+nums[upper];
                if(sum==target)
                {
                    return sum;
                }
                else 
                {
                    if(Math.abs(sum-target)<Math.abs(diffTarget))
                    {
                        diffTarget = target-sum;
                    }
                    if(sum>target)
                    {
                        //move closer to target sum.
                        while(lower<upper && nums[upper] == nums[upper-1]){
                            upper--;
                        }
                        upper--;
                    }
                    else
                    {
                        //move closer to target sum.
                        while(lower<upper && nums[lower] == nums[lower+1])
                        {
                            lower++;
                        }
                        lower++;
                    }
                }
            }
        }
        return target-diffTarget;
    }
}