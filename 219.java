/**
219. Contains Duplicate II
Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
*/
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        final Map<Integer,Integer> indexMap = new HashMap<>();
        for(int i = 0; i<nums.length;i++)
        {
            final Integer index = indexMap.get(nums[i]);
            if(index==null|| i-index>k)
            {
                indexMap.put(nums[i],i);
            }
            else
            {
                return true;
            }
        }
        return false;
    }
}