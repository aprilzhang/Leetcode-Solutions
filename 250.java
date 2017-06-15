/**
250. Count Univalue Subtrees
Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

For example:
Given binary tree,
              5
             / \
            1   5
           / \   \
          5   5   5
return 4.
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
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        isUnival(root);
        return count;
    }
    
    private boolean isUnival(TreeNode root)
    {
        if(root==null)
        {
            return false;
        }
        
        boolean unival = true;
        if(root.left!=null)
        {
            unival &=isUnival(root.left)&&root.val==root.left.val;
        }
        if(root.right!=null)
        {
            unival &=isUnival(root.right)&&root.val==root.right.val;
        }
        
        if(unival)
        {
            count++;
        }
        
        return unival;
    }
}

//Shorter but not faster solution
public class Solution {
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        all(root,0);//dummy 0
        return count;
    }
    
    boolean all(TreeNode root, int val) {
        if (root == null)
            return true;
        if (all(root.left, root.val) & all(root.right, root.val))
        {
            count++;
            return root.val == val;
        }
        return false;
    }
}