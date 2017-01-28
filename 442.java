/**
442. Find All Duplicates in an Array
Given an array of integers, 1 = a[i] = n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
*/
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        final int[] count = new int[nums.length+1];
        for(int num:nums)
        {
            count[num]+=1;
        }
        
        final List<Integer> duplicates = new ArrayList<>();
        for(int i = 0; i<count.length; i++)
        {
            if(count[i]==2)
            {
                duplicates.add(i);
            }
        }
        return duplicates;
    }
}