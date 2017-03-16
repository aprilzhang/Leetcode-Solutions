/**
228. Summary Ranges
Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
*/
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        final List<String> result = new ArrayList<>();
        if(nums==null||nums.length==0)
        {
            return result;
        }
        for(int i = 0;i<nums.length;i++)
        {
            int lower = nums[i];
            while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) 
            {
                i++;
            }
            if(lower==nums[i])
            {
                result.add(""+lower);
            }
            else
            {
                result.add(lower+"->"+nums[i]);
            }
        }
        return result;
    }
}