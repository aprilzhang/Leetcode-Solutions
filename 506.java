/**
506. Relative Ranks
Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".

Example 1:
Input: [5, 4, 3, 2, 1]
Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal". 
For the left two athletes, you just need to output their relative ranks according to their scores.
Note:
N is a positive integer and won't exceed 10,000.
All the scores of athletes are guaranteed to be unique.
*/
public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        final Integer[] rank = new Integer[nums.length];
        for(int i =0;i<nums.length;i++)
        {
            rank[i] = i;
        }
        Arrays.sort(rank, (i,j)->(nums[j]-nums[i]));
        System.out.println(Arrays.toString(rank));
        final String[] result = new String[rank.length];
        for(int i =0;i<rank.length;i++)
        {
            switch(i)
            {
                case 0:
                    result[rank[i]] = "Gold Medal";
                    break;
                case 1:
                    result[rank[i]] = "Silver Medal";
                    break;
                case 2:
                    result[rank[i]] = "Bronze Medal";
                    break;
                default:
                    result[rank[i]] = Integer.toString(i+1);
            }
        }
        return result;
    }
}