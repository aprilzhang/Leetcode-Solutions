/**
152. Maximum Product Subarray
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*/
//Similar to kadane algorithm, but need to consider about the case when multiply two negative values
public class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxEndHerePre = nums[0];
        int minEndHerePre = nums[0];
        int maxSoFar = nums[0];
        int maxEndHere = nums[0];
        int minEndHere = nums[0];
        for(int i =1;i<nums.length;i++)
        {
            maxEndHere = Math.max(Math.max(maxEndHerePre * nums[i], minEndHerePre * nums[i]), nums[i]);
            minEndHere = Math.min(Math.min(maxEndHerePre * nums[i], minEndHerePre * nums[i]), nums[i]);
            maxSoFar = Math.max(maxEndHere,maxSoFar);
            maxEndHerePre = maxEndHere;
            minEndHerePre = minEndHere;
        }
        return maxSoFar;
    }
}