/**
169. Majority Element
Given an array of size n, find the majority element. The majority element is the element that appears more than ? n/2 ? times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/
public class Solution {
    public int majorityElement(int[] nums) {
        final Map<Integer,Integer> counts = new HashMap<>();
        final int target = nums.length/2;
        for(int num:nums)
        {
            Integer count = counts.get(num);
            if(count==null)
            {
                count = 0;
            }
            if(count+1>target)
            {
                return num;
            }
            counts.put(num,count+1);
        }
        return 0;
    }
}

//Better solution
public class Solution {
    public int majorityElement(int[] num) {

        int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;
            
        }
        return major;
    }
}