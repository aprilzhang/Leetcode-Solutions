/**
406. Queue Reconstruction by Height
Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.

Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
*/
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b)->compare(a,b));
        final List<int[]> result = new ArrayList<>();
        for(int index =0;index<people.length;index++)
        {
            final int[] pair = people[index];
            result.add(pair[1],pair);
        }
        return result.toArray(new int[result.size()][]);
    }
    
    private static int compare(int[] a, int[] b)
    {
        int firstDiff = b[0]-a[0];
        return firstDiff==0?a[1]-b[1]:firstDiff;
    }
}