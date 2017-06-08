/**
45. Jump Game II
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Note:
You can assume that you can always reach the last index.
*/
//My solution
//TLE
public class Solution {
    public int jump(int[] nums) {
        final int[] minJumps = new int[nums.length];
        for(int i = 1;i<nums.length;i++)
        {
            minJumps[i] = Integer.MAX_VALUE;
        }
        for(int i = 0;i<nums.length;i++)
        {
            for(int j = 1;j<=nums[i]&&j<nums.length-i;j++)
            {
                minJumps[i+j] = Math.min(minJumps[i]+1,minJumps[i+j]);
            }
        }
        return minJumps[nums.length-1];
    }
}

//The correct solution
//A bit like BFS
public class Solution {
    public int jump(int[] nums) {
    	 if(nums==null||nums.length<2)
    	 {
    	     return 0;
    	 }
    	int jumps = 0;
    	int curEnd = 0;
    	int curFarthest = 0;
    	for (int i = 0; i < nums.length - 1; i++) 
    	{
    	    //While i<=curEnd, find the farthest point the current jump can reach
    		curFarthest = Math.max(curFarthest, i + nums[i]);
    		if (i == curEnd) {
    			jumps++;
    			curEnd = curFarthest;
    		}
    	}
    	return jumps;
    }
}