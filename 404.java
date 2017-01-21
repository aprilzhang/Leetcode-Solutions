/����
404. Sum of Left Leaves
Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
��/
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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        else if(isLeaf(root.left))
        {
            return root.left.val+sumOfLeftLeaves(root.right);
        }
        else if(isLeaf(root.right))
        {
            return sumOfLeftLeaves(root.left);
        }
        else
        {
            return sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);
        }
    }
    
    public static boolean isLeaf(TreeNode root)
    {
        return root!=null&&root.left==null&&root.right==null;
    }
}