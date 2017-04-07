/**
162. Find Peak Element
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ? num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -8.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

click to show spoilers.

Note:
Your solution should be in logarithmic complexity.
*/
public class Solution {
    public int findPeakElement(int[] nums) {
        int a = 0;
        int b = nums.length-1;
        while(a<b)
        {
            int mid = (a+b)/2;
            if((mid==0||nums[mid]>nums[mid-1])
            &&(mid ==nums.length-1||nums[mid]>nums[mid+1]) )
            {
                return mid;
            }
            else if((mid>0&&nums[mid]<nums[mid-1])
            &&(mid ==nums.length-1||nums[mid]>nums[mid+1]) )
            {
                b = mid-1;
            }
            else if((mid==0||nums[mid]>nums[mid-1])
            &&(mid <nums.length-1&&nums[mid]<nums[mid+1]) )
            {
                a = mid+1;
            }
            else
            {
                a = mid+1;
            }
        }
        return a;
    }
}
//Faster solution
//Find local maximum
public class Solution {
    public int findPeakElement(int[] nums) {
        int a = 0;
        int b = nums.length-1;
        while(a<b)
        {
            int mid = (a+b)/2;
            if(nums[mid] < nums[mid+1])
                a = mid+1;
            else
                b = mid;
        }
        return a;
    }
}