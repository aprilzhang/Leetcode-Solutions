/**
Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false
*/

//Talk about trade off

//TLE
public class TwoSum {
    private final Set<Integer> nums = new HashSet<>();
    private final Set<Integer> sums = new HashSet<>();
    /** Initialize your data structure here. */
    public TwoSum() {
        
    }
    
    /** Add the number to an internal data structure.. */
	//O(n)
    public void add(int number) {
        if(nums.contains(number))
        {
            sums.add(number*2);
        }
        else
        {
            for(int num:nums)
            {
                sums.add(num+number);
            }
            nums.add(number);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
	//O(1)
    public boolean find(int value) {
        return sums.contains(value);
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
 //Accepted solution
 public class TwoSum {
    private final Map<Integer,Integer> numCounts = new HashMap<>();
    /** Initialize your data structure here. */
    public TwoSum() {
        
    }
    
    /** Add the number to an internal data structure.. */
	//O(1)
    public void add(int number) {
        numCounts.put(number,numCounts.getOrDefault(number,0)+1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
	//O(n)
    public boolean find(int value) {
        for(int num:numCounts.keySet())
        {
            final int target = value-num;
            if(numCounts.containsKey(target))
            {
                if(target!=num||numCounts.get(target)>=2)
                return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */