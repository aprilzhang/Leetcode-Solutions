/**
81. Search in Rotated Sorted Array II
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Write a function to determine if a given target is in the array.

The array may contain duplicates.
*/

//Wrong answer
public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null||nums.length==0)
        {
            return false;
        }
        int a = 0;
        int b = nums.length-1;
        while(a<b)
        {
            final int mid = (a+b)/2;
            if(nums[mid]<nums[b])
            {
                b = mid;
            }
            else if(nums[mid]>nums[b])
            {
                a = mid+1;
            }
            else //equals
            {
                b--;
            }
        }
        
        final int pivot = a;
        int lower = 0;
        int upper = nums.length-1;
        while(lower<upper)
        {
           final int mid = (lower+upper)/2;
           final int movedMid = (mid+pivot)%nums.length;
           if(nums[movedMid] == target)
           {
               return true;
           }
           else if(nums[movedMid]<target)
           {
               lower= mid+1;
           }
           else
           {
               upper = mid;
           }
        }
        return nums[(lower+pivot)%nums.length] == target;
    }
}