/**
300. Longest Increasing Subsequence
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
*/

//O(N^2) solution
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length==0)
        {
            return 0;
        }
        final int[] cache = new int[nums.length];
        
        int max = 0;
        for( int i =0;i<nums.length;i++)
        {
            int longestAtI = 0;
            for(int j = 0;j<i;j++)
            {
                if(nums[j]<nums[i])
                {
                    longestAtI = Math.max(longestAtI,cache[j]);
                }
            }
            cache[i] = longestAtI+1;
            
            max = Math.max(max,cache[i]);
        }
        
        return max;
    }
}

//O(nlogn) solution
/**
Very similiar to my thought 
        //Cache the minimum number with the given length
tails is an array storing the smallest tail of all increasing subsequences with length i+1 in tails[i].
For example, say we have nums = [4,5,6,3], then all the available increasing subsequences are:

len = 1   :      [4], [5], [6], [3]   => tails[0] = 3
len = 2   :      [4, 5], [5, 6]       => tails[1] = 5
len = 3   :      [4, 5, 6]            => tails[2] = 6
NOTE We can easily prove that tails is a increasing array. 
Therefore it is possible to do a binary search in tails array to find the one needs update.

Each time we only do one of the two:

(1) if x is larger than all tails, append it, increase the size by 1
(2) if tails[i-1] < x <= tails[i], update tails[i]
Doing so will maintain the tails invariant. The the final answer is just the size.
*/
public class Solution {
    public int lengthOfLIS(int[] nums) {  
        
        //Cache the minimum number with the given length
        final int[] cache = new int[nums.length];
        
        int count = 0;

        for(int number : nums) {
            //binary search returns:
            //index of the search key, if it is contained in the array within the specified range;
            //otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.
            int i = Arrays.binarySearch(cache, 0, count, number);
            if(i < 0)
            {
                i = -(i + 1);
            }
            cache[i] = number;
            if(i == count) //if x is larger than all tails, append it, increase the size by 1
            {
                count++;
            }
        }

        return count;
    }
}