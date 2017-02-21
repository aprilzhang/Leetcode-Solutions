 /**
 220. Contains Duplicate III
 Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 */
 public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0)
        {
            return false;
        }
        final Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            final long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            final long bucket = remappedNum / ((long) t + 1);
            final boolean satisfyCondition = map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                        || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t);
            if (satisfyCondition)
            {
                 return true;
            }
            if (map.entrySet().size() >= k) 
            {
                final long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }
}