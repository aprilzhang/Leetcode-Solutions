/**
118. Pascal's Triangle
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        final List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0)
        {
            return result;
        }
        result.add(Arrays.asList(1));
        for(int row = 1;row<numRows;row++)
        {
            final List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            for(int i =1;i<result.get(row-1).size();i++)
            {
                newRow.add(result.get(row-1).get(i-1)+result.get(row-1).get(i));
            }
            newRow.add(1);
            result.add(newRow);
        }
        return result;
    }
}