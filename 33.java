/**
33. Search in Rotated Sorted Array
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/
//Correct solution
public class Solution {
    public int search(int[] nums, int target) {
        int a = 0;
        int b = nums.length-1;
        //Find rotation index
        while(a<b)
        {
            final int mid=(a+b)/2;
            if(nums[mid]>nums[b])
            {
                a=mid+1;
            }
            else 
            {
                b=mid;
            }
        }
        final int rotation =a;
        
        final int n = nums.length;
        a=0;
        b=n-1;
        while(a<=b)
        {
            final int mid = (a+b)/2;
            final int realmid=(mid+rotation)%n;
            if(nums[realmid]==target)
            {
                return realmid;
            }
            else if(nums[realmid]<target)
            {
                a=mid+1;
            }
            else
            {
                b=mid-1;
            }
        }
        return -1;
    }
}
// why my solution is incorrect?
public class Solution {
    public int search(int[] nums, int target) {
        int a = 0;
        int b = nums.length-1;
        while(a<=b)
        {
            final int mid = (a+b)/2;
            System.out.println(mid);
            if(nums[mid] == target)
            {
                return mid;
            }
            if(nums[a]<nums[b])
            {
                if(target<=nums[mid])
                {
                    b = mid;
                }
                else
                {
                    a = mid+1;
                }
            }
            else
            {
                if((nums[a]<=target &&target>nums[mid])
                || (nums[a]>target&&target<=nums[mid]))
                {
                    b = mid;
                }
                else
                {
                    a = mid+1;
                }
            }
        }
        return -1;
    }
}