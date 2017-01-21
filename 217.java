/¡Á¡Á
217. Contains Duplicate
Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
¡Á/
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        while(i<nums.length&&(i==0||nums[i-1]!=nums[i]))
        {
            i++;
        }
        return i!=nums.length;
    }
}