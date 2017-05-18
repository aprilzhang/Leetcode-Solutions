/**
78. Subsets
Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        final List<List<Integer>> result = new ArrayList<>();
        if(nums.length==0)
        {
            return result;
        }
        result.add( new ArrayList<Integer>());
        final List<List<Integer>> newResults = new ArrayList<>();
        for(int num:nums)
        {
            for(List<Integer> list:result)
            {
                final List<Integer> newList = new ArrayList<Integer>(list);
                newList.add(num);
                newResults.add(newList);
            }
            result.addAll(newResults);
            newResults.clear();
        }
        return result;
    }
}

//Recursive solution
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }
    
    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}