public class Solution {
    public int[] searchRange(int[] nums, int target) {
        final int[] result = new int[]{-1,-1};
        if(nums==null||nums.length==0)
        {
            return result;
        }
        
        int a = 0;
        int b = nums.length-1;
        while(a<b)
        {
            final int mid = (a+b)/2;
            if(target <= nums[mid])
            {
                b = mid;
            }
            else
            {
                a = mid+1;
            }
        }
        
        if (nums[a]!=target)
        {
            return result;
        }
        result[0] = a;
        
        //reinitialise a and b
        a = 0;
        b = nums.length-1;
        while(a<b)
        {
            final int mid = (a+b)/2+1;// Make mid biased to the right
            if(target < nums[mid])
            {
                b = mid-1;
            }
            else
            {
                a = mid;
            }
        }
        result[1] = b;
        return result;
    }
}