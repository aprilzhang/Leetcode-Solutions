/**
380. Insert Delete GetRandom O(1)
Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
Example:

// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
randomSet.getRandom();
*/
//My solution, very fast
public class RandomizedSet {
    private List<Integer> values = new ArrayList<>();
    private Map<Integer,Integer> positions = new HashMap<>();
    private final Random random = new Random();
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(positions.containsKey(val))
        {
            return false;
        }
        values.add(val);
        positions.put(val,values.size()-1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!positions.containsKey(val))
        {
            return false;
        }
        int valPosition = positions.get(val);
        positions.remove(val,valPosition);

        int lastVal = values.remove(values.size()-1);
        if(lastVal!=val)
        {
            positions.put(lastVal,valPosition);
            values.set(valPosition,lastVal);
        }
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        if(values.isEmpty())
        {
            return -1;
        }
        int ran = random.nextInt(positions.size());
        return values.get(ran);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
 
 

public class RandomizedSet {
    private final Random random = new Random();
    private final List<Integer> list = new ArrayList<>();
    private final Map<Integer, Integer> map = new HashMap<>();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val))
        {
            map.put(val,list.size());
            list.add(val);
            return true;
        }
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val))
        {
            return false;
        }
        final int valIndex = map.get(val);
        
        // not the last one than swap the last one with this val
        if (valIndex < list.size() - 1 ) 
        { 
            int lastone = list.get(list.size() - 1 );
            list.set( valIndex , lastone );
            map.put(lastone, valIndex);
        }
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        final int index = random.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */