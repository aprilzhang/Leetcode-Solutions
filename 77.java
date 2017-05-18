/**
77. Combinations
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        final List<List<Integer>> result = new ArrayList<>();
        
        backTrack(result, new ArrayList<Integer>(), n,1,k);
        return result;
    }
    
    private void backTrack(List<List<Integer>> result, final List<Integer> tempList, 
        int max, int start, int targetLength)
    {
        if(tempList.size()==targetLength)
        {
            result.add(new ArrayList<>(tempList));
        }
        for(int i = start;i<=max;i++)
        {
            tempList.add(i);
            backTrack(result,tempList,max,i+1,targetLength);
            tempList.remove(tempList.size()-1);
        }
    }
}