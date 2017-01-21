/**
350. Intersection of Two Arrays II
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
*/
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        final List<Integer> intersectionList = new ArrayList<>();
        int pointer1 = 0;
        int pointer2 = 0;
        while(pointer1<nums1.length&&pointer2<nums2.length)
        {
            if(nums1[pointer1]<nums2[pointer2])
            {
                pointer1++;
            }
            else if(nums1[pointer1]>nums2[pointer2])
            {
                pointer2++;
            }
            else
            {
                intersectionList.add(nums1[pointer1]);
                pointer1++;
                pointer2++;
            }
        }
        final int count = intersectionList.size();
        final int[] result = new int[count];
        for(int i =0;i<count;i++)
        {
            result[i] = intersectionList.get(i);
        }
        return result;
    }
}