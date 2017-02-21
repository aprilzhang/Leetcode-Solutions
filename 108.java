/**
108. Convert Sorted Array to Binary Search Tree
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null)
        {
            return null;
        }
        return sortedArrayToNode(nums,0,nums.length);
    }
    
    private static TreeNode sortedArrayToNode(int[] nums, int lower, int upper)
    {
        if(lower>=upper)
        {
            return null;
        }
        final int mid = (lower+upper-1)/2;
        final TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToNode(nums, lower, mid);
        node.right = sortedArrayToNode(nums, mid+1, upper);
        return node;
    }
    
}