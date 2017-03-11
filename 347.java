/**
347. Top K Frequent Elements
Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ¡Ü k ¡Ü number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        final Map<Integer, Integer> count = new HashMap<>();
        for(int num:nums)
        {
            if(count.containsKey(num))
            {
                count.put(num,count.get(num)+1);
            }
            else
            {
                count.put(num,1);
            }
        }
        
        final List<Integer> list =new LinkedList<>( count.keySet() );
        Collections.sort( list, (k1,k2)->count.get(k2)-count.get(k1));
        
        return list.subList(0,k);
    }
}

//Slightly faster
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        final Map<Integer, Integer> counts = new HashMap<>();
        for(int num:nums)
        {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        
        final List<Integer>[] bucket = new List[nums.length + 1];
        
        for(int i =0;i<nums.length + 1;i++)
        {
    	    bucket[i] = new ArrayList<>();
        }   
        counts.entrySet().forEach(entry->bucket[entry.getValue()].add(entry.getKey()));
        
        final List<Integer> result = new ArrayList<>();
    	for (int count = bucket.length - 1; count >= 0 && result.size() < k; count--) 
    	{
    	    result.addAll(bucket[count]);
    	}
    	return result;
    }
}

//Fastest solution, but couldnt tell the diff with the 2nd solution...
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
    
    	List<Integer>[] bucket = new List[nums.length + 1];
    	Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
    
    	for (int n : nums) {
    		frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
    	}
    
    	for (int key : frequencyMap.keySet()) {
    		int frequency = frequencyMap.get(key);
    		if (bucket[frequency] == null) {
    			bucket[frequency] = new ArrayList<>();
    		}
    		bucket[frequency].add(key);
    	}
    
    	List<Integer> res = new ArrayList<>();
    
    	for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
    		if (bucket[pos] != null) {
    			res.addAll(bucket[pos]);
    		}
    	}
    	return res;
    }
}