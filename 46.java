/**
46. Permutations
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
         List<List<Integer>> previous= new ArrayList<>();
        previous.add(new ArrayList<>());
         List<List<Integer>> current= new ArrayList<>();
        for(int num:nums)
        {
            for(List<Integer> list:previous)
            {
                current.addAll(addAllPossibilities(list,num));
            }
            previous = current;
            current= new ArrayList<>();
        }
        return previous;
    }
    
    public List<List<Integer>> addAllPossibilities(List<Integer> previous, int num)
    {
        final List<List<Integer>> result = new ArrayList<>();
        for(int i =0;i<=previous.size();i++)
        {
            final List<Integer> newList = new ArrayList<>(previous);
            newList.add(i,num);
            result.add(newList);
        }
        return result;
    }
}