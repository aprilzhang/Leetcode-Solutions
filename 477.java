/**
477. Total Hamming Distance
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Now your job is to find the total Hamming distance between all pairs of the given numbers.

Example:
Input: 4, 14, 2

Output: 6

Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
showing the four bits relevant in this case). So the answer will be:
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
*/
//My slow solution
public class Solution {
    public int totalHammingDistance(int[] nums) {
        int totalDistance = 0;
        for(int i = 0; i<nums.length;i++)
        {
            for(int j = i+1;j<nums.length;j++)
            {
                totalDistance += Integer.bitCount(nums[i]^nums[j]);
            }
        }
        return totalDistance;
    }
}

//Better solution
public class Solution {
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        final int n = nums.length;
        for (int j=0;j<32;j++) 
        {
            int bitCount = 0;
            for (int i=0;i<n;i++) 
            {
                bitCount += (nums[i] >> j) & 1;
            }
            total += bitCount*(n - bitCount);
        }
        return total;
    }
}