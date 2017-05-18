/**
39. Combination Sum
Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
*/
public class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        final List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), 0, nums, 0,target);
        return list;
    }
    
    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int tempSum,
        int[] nums, int start, int target)
    {
        if(tempSum>target)
        {
            return;
        }
        if(tempSum==target)
        {
            list.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList,tempSum+nums[i], nums, i ,target);
            tempList.remove(tempList.size() - 1);
        }
    }
}

//My first draft, accepted but super slow!
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        final List<List<Integer>> result = new ArrayList<>();
        if(target==0)
        {
            return result;
        }
        final Map<List<Integer>,Integer> currentSums = new HashMap<>();
        for(int i = 0;i<candidates.length;i++)
        {
            addCombinations(result,currentSums,candidates,i,target);
        }
        
        return result;
    }
    
    public void addCombinations(List<List<Integer>> result,
            Map<List<Integer>,Integer> currentSums, int[] candidates, int index, int target)
    {
        final int previousSize = currentSums.size();
        final int currentValue = candidates[index];
        
        currentSums.put(new ArrayList<>(),0);
        
        final Set<Map.Entry<List<Integer>,Integer>> entries = new HashSet<>(currentSums.entrySet());
        
        for(Map.Entry<List<Integer>,Integer> entry:entries)
        {
            int newSum = entry.getValue()+currentValue;
            final List<Integer> list = new ArrayList<>();
            list.addAll(entry.getKey());
            
            while(newSum<=target)
            {
                list.add(currentValue);
                final List<Integer> newList = new ArrayList<>(list);
                
                final Integer previousSum = currentSums.put(newList,newSum);
                
                if(newSum==target)
                {
                    result.add(newList);
                }
                newSum+=currentValue;
            }
        }
    }
}