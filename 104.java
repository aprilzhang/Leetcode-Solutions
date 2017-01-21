/**
104. Maximum Depth of Binary Tree
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
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
    public int maxDepth(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        else if(root.left==null&&root.right==null)
        {
            return 1;
        }
        else if(root.left==null)
        {
            return 1+maxDepth(root.right);
        }
        else if(root.right==null)
        {
            return 1+maxDepth(root.left);
        }
        else
        {
            return 1+ Math.max(maxDepth(root.left),maxDepth(root.right));
        }
    }
}