/**
154. Find Minimum in Rotated Sorted Array II
Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.
*/
public class Solution {
    public int findMin(int[] nums) {
        //Find maximum
        int a = 0;
        int b = nums.length-1;
        while(a<b)
        {
            final int mid = (a+b)/2;
            if (nums[mid] > nums[b]) {
                a = mid + 1;
            }
            else if (nums[mid] < nums[b]) {
                b = mid;
            }
            else {
                b--;
            }
        }
        return nums[a];
    }
}