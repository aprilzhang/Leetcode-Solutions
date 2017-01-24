/**
494. Target Sum
You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
Note:
The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.
*/

//Slow recursive solution
public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWays(0,nums,S);
    }
    
    private static int findTargetSumWays(int startIndex, int[] nums, int S)
    {
        if(nums==null|| startIndex==nums.length)
        {
            return 0;
        }
        if(startIndex==nums.length-1)
        {
            return (S==nums[startIndex]?1:0)
            +(S==-nums[startIndex]?1:0);
        }
        else
        {
            return findTargetSumWays(startIndex+1,nums,S+nums[startIndex])+findTargetSumWays(startIndex+1,nums,S-nums[startIndex]);
        }
    }
}

// Best solution
/**The recursive solution is very slow, because its runtime is exponential

The original problem statement is equivalent to:
Find a subset of nums that need to be positive, and the rest of them negative, such that the sum is equal to target

Let P be the positive subset and N be the negative subset
For example:
Given nums = [1, 2, 3, 4, 5] and target = 3 then one possible solution is +1-2+3-4+5 = 3
Here positive subset is P = [1, 3, 5] and negative subset is N = [2, 4]

Then let's see how this can be converted to a subset sum problem:

                  sum(P) - sum(N) = target
sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
                       2 * sum(P) = target + sum(nums)
So the original problem has been converted to a subset sum problem as follows:
Find a subset P of nums such that sum(P) = (target + sum(nums)) / 2

Note that the above formula has proved that target + sum(nums) must be even
We can use that fact to quickly identify inputs that do not have a solution (Thanks to @BrunoDeNadaiSarnaglia for the suggestion)

Here is Java solution (15 ms)
*/

public class Solution {
    public int findTargetSumWays(int[] nums, int s) {
        //sum(P) = (target + sum(nums)) / 2
        //Find sum
        int sum = 0;
        for (int n : nums)
        {
            sum += n;
        }
        
        if(sum < s || (s + sum) % 2 !=0 )
        {
            //No solution exist
             return 0;
        }
        
        int[] dp = new int[2*sum+1]; //-sum .... 0 ... sum
        dp[0+sum] = 1; //one way to get 0
        for(int i = 0; i<nums.length; i++){
            final int[] next = new int[2*sum+1];
            for(int k = 0; k<2*sum+1; k++){
                if(dp[k]!=0){
                    next[k + nums[i]] += dp[k];
                    next[k - nums[i]] += dp[k];
                }
            }
            dp = next;
        }
        return dp[s + sum];
    }
}