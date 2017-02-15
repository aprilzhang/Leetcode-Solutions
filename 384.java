/**
384. Shuffle an Array
Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();
*/
public class Solution {
    private int[] rawData;

    public Solution(int[] nums) {
        this.rawData = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return rawData;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        final List<Integer> list =  IntStream.of(rawData).boxed().collect(Collectors.toList());
        Collections.shuffle(list);
        return list.stream().mapToInt(i->i).toArray();
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
 //Collections.shuffle is a bit over kill
 public class Solution {
    private final Random random = new Random(); 
    private int[] rawData;

    public Solution(int[] nums) {
        this.rawData = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return rawData;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if(rawData == null) 
            return null;
            
        final int[] a = rawData.clone();
        for(int j = 1; j < a.length; j++) {
            int i = random.nextInt(j + 1);
            swap(a, i, j);
        }
        return a;
    }
    
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}