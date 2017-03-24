/**
128. Longest Consecutive Sequence
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/
public class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        final Map<Integer,Integer> sequenceLength = new HashMap<>();
        for(int num:nums)
        {
            //Dulplicates
            if(sequenceLength.containsKey(num))
            {
                continue;
            }
            
            int left = sequenceLength.getOrDefault(num-1,0);
            int right = sequenceLength.getOrDefault(num+1,0);
            int sum = left+right+1;
            sequenceLength.put(num, sum);
            
            max = Math.max(max,sum);
            
            sequenceLength.put(num-left,sum);
            sequenceLength.put(num+right,sum);
        }
        return max;
    }
}