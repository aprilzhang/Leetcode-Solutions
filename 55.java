//My solution 
//TLE 
public class Solution {
    public boolean canJump(int[] nums) {
        if(nums==null||nums.length==0)
        {
            return false;
        }
        final boolean[] canJump =  new boolean[nums.length];
        canJump[0] = true;
        for(int i =0;i<nums.length;i++)
        {
            if(!canJump[i])
            {
                continue;
            }
            
            if(i+nums[i]>=nums.length-1)
            {
                return true;
            }
            for(int j = nums[i];j>=1;j--)
            {
                canJump[i+j]= true;
            }
        }
        
        return false;
    }
}

//Accepted solutionpublic class Solution {
    public boolean canJump(int[] nums) {
        if(nums==null||nums.length==0)
        {
            return false;
        }
        int maxReach = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(i>maxReach) 
            {
                return false;
            }
            maxReach = Math.max(nums[i]+i,maxReach);
        }
        return true;
    }
}