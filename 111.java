/**
111. Minimum Depth of Binary Tree
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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
//My solutions
public class Solution {
    public int minDepth(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        //If is leaf
        if(root.left==null&&root.right==null)
        {
            return 1;
        }
        else if(root.left==null)
        {
            return 1+minDepth(root.right);
        }
        else if(root.right==null)
        {
            return 1+minDepth(root.left);
        }
        else
        {
            return 1+Math.min(minDepth(root.left),minDepth(root.right));
        }
    }
}
public class Solution {
    public int minDepth(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        return minDepthHelper(root);
    }
    
    private static int minDepthHelper(TreeNode root)
    {
        if(root==null)
        {
            return Integer.MAX_VALUE;
        }
        //If is leaf
        if(root.left==null&&root.right==null)
        {
            return 1;
        }
        return 1+Math.min(minDepthHelper(root.left),minDepthHelper(root.right));
    }
}

//Shorter but not faster solution
public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
    }