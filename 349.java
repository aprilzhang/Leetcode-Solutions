/**
349. Intersection of Two Arrays
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
*/
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        final int[] intersection = new int[nums1.length];
        int count = 0;
        int pointer1 = 0;
        int pointer2 = 0;
        while(pointer1<nums1.length&&pointer2<nums2.length)
        {
            if((pointer1>0&&nums1[pointer1]==nums1[pointer1-1])
            ||nums1[pointer1]<nums2[pointer2])
            {
                pointer1++;
            }
            else if((pointer2>0&&nums2[pointer2]==nums2[pointer2-1])
                ||nums1[pointer1]>nums2[pointer2])
            {
                pointer2++;
            }
            else
            {
                //equal
                intersection[count++]=nums1[pointer1];
                pointer1++;
                pointer2++;
            }
        }
        return Arrays.copyOf(intersection,count);
    }
}