/**
303. Range Sum Query - Immutable
Given an integer array nums, find the sum of the elements between indices i and j (i = j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
*/
public class NumArray {
    private final int[] sums;

    public NumArray(int[] nums) {
        final int length = nums.length;
        sums = new int[length];
        for(int i = 0;i<length;i++)
        {
            sums[i] = (i>0?sums[i-1]:0)+nums[i];
        }
        
    }
    
    public int sumRange(int i, int j) {
        return sums[j]-(i>0?sums[i-1]:0);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */