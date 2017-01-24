/**
370. Range Addition
Assume you have an array of length n initialized with all 0's and are given k update operations.

Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.

Return the modified array after all k operations were executed.

Example:

Given:

    length = 5,
    updates = [
        [1,  3,  2],
        [2,  4,  3],
        [0,  2, -2]
    ]

Output:

    [-2, 0, 3, 5, 3]
Explanation:

Initial state:
[ 0, 0, 0, 0, 0 ]

After applying operation [1, 3, 2]:
[ 0, 2, 2, 2, 0 ]

After applying operation [2, 4, 3]:
[ 0, 2, 5, 5, 3 ]

After applying operation [0, 2, -2]:
[-2, 0, 3, 5, 3 ]
*/
public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        final int[] result = new int[length];
        for(int i = 0; i<updates.length;i++)
        {
            final int inc = updates[i][2];
            for(int j = updates[i][0];j<=updates[i][1];j++ )
            {
                result[j]+=inc;
            }
        }
        return result;
    }
	
	//Better solution
	    public int[] getModifiedArray(int length, int[][] updates) {
        final int[] result = new int[length];
        for(int i = 0; i<updates.length;i++)
        {
            final int inc = updates[i][2];
            result[updates[i][0]]+=inc;
            if(updates[i][1]+1<length)
            {
                result[updates[i][1]+1]-=inc;
            }
        }
        for(int i = 1; i <length;i++)
        {
            result[i] += result[i-1];
        }
        return result;
    }
}