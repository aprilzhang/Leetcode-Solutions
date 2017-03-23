/**
287. Find the Duplicate Number
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
*/
public class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i =1;i<nums.length;i++)
        {
            if(nums[i]==nums[i-1])
            {
                return nums[i];
            }
        }
        throw new AssertionError("not found");
    }
}

//Best solution
//Find duplication in linked list --similar question in cracking code review
public class Solution {
    public int findDuplicate(int[] nums) {
        if (nums.length > 1)
    	{
    		int slow = nums[0];
    		int fast = nums[nums[0]];
    		while (slow != fast)
    		{
    			slow = nums[slow];
    			fast = nums[nums[fast]];
    		}
    
    		fast = 0;
    		while (fast != slow)
    		{
    			fast = nums[fast];
    			slow = nums[slow];
    		}
    		return slow;
    	}
        throw new AssertionError("not found");
    }
}