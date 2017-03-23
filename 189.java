/**
189. Rotate Array
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

[show hint]

Hint:
Could you do it in-place with O(1) extra space?
Related problem: Reverse Words in a String II
*/
public class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
//My solution is wrong because it only works on prime (I guess)
//In the case of e.g. n = 6, k =2, some indexes are never visited
public class Solution {
    public void rotate(int[] nums, int k) {
        final int n = nums.length;
        int temp = nums[0];
        int i = 0;
        while(true)
        {
            final int index= Math.floorMod(i-k, n);
            if(index == 0)
            {
               nums[i] = temp;
               return;
            }
            nums[i] = nums[index];
            i = index;
        }
    }
}