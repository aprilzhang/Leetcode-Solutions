/**
153. Find Minimum in Rotated Sorted Array

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
*/
public class Solution {
    public int findMin(int[] nums) {
        if(nums==null||nums.length==0)
        {
          return 0 ;
        }
        int a =0;
        int b =nums.length-1;
        while(a<b)
        {
            if(nums[a]<=nums[b])
            {
                return nums[a];
            }
            final int mid = (a+b-1)/2;
            if(nums[a]<=nums[mid])
            {
                a = mid+1;
            }
            else
            {
                b = mid;
            }
        }
        return nums[a];
    }
}