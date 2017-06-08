//My acceptted solution
// O(N^2)
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
    public boolean isBalanced(TreeNode root) {
        if(root==null)
        {
            return true;
        }
        return Math.abs(height(root.left)-height(root.right))<=1
            &&isBalanced(root.left)&&isBalanced(root.right);
    }
    
    private int height(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        return 1+Math.max(height(root.left),height(root.right));
    }
}
//Best solution
//O(N)
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return balancedHeight(root)!=-1;
    }
    //the height of the current node in DFS recursion
    //When the sub tree of the current node (inclusive) is balanced, the function balancedHeight() returns
    //a non-negative value as the height. Otherwise -1 is returned.
    private int balancedHeight(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int leftHeight = balancedHeight (root.left);
        //Left is unbalanced
        if (leftHeight == -1)
        {
            return -1;
        }
        int rightHeight = balancedHeight (root.right);
        //Right is unbalanced
        if (rightHeight == -1)
        {
            return -1;
        }
        //Height of left is unbalanced with right
        if (Math.abs(leftHeight - rightHeight) > 1)  
        {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}