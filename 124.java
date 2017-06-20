/**
124. Binary Tree Maximum Path Sum
Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6
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
 
//My accepted solution
public class Solution {
    public int maxPathSum(TreeNode root) {
        final int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        maxUnfinishedSums(root,maxSum);
        
        return maxSum[0];
    }
    
    private static int maxUnfinishedSums(TreeNode root,int[] maxSum)
    {
        if(root==null)
        {
            return 0;
        }
        if(root.left==null&&root.right==null)
        {
            maxSum[0] = Math.max(root.val,maxSum[0]);
            return root.val;
        }
        
        final int leftMax =maxUnfinishedSums(root.left,maxSum);
        final int rightMax =maxUnfinishedSums(root.right,maxSum);
        final int newOveralSum  = (leftMax<0?0:leftMax)
                                +(rightMax<0?0:rightMax)
                                +root.val;
        
        maxSum[0] = Math.max(newOveralSum,maxSum[0]);
        
        return Math.max(Math.max(leftMax,rightMax)+root.val,root.val);
    }
}

//Refactor a bit
public class Solution {
    public int maxPathSum(TreeNode root) {
        final int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        maxUnfinishedSums(root,maxSum);
        
        return maxSum[0];
    }
    
    private static int maxUnfinishedSums(TreeNode root,int[] maxSum)
    {
        if(root==null)
        {
            return 0;
        }
        
        final int leftMax =maxUnfinishedSums(root.left,maxSum);
        final int rightMax =maxUnfinishedSums(root.right,maxSum);
        
        maxSum[0] = Math.max(leftMax+rightMax+root.val,maxSum[0]);
        
        return Math.max(Math.max(leftMax,rightMax)+root.val,0);
    }
}