/**
114. Flatten Binary Tree to Linked List
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
click to show hints.

Hints:
If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal
*/

//My solution

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
    public void flatten(TreeNode root) {
        if(root==null)
        {
            return;
        }
        
        flatten(root.left);
        flatten(root.right);
        
        if(root.left!=null)
        {
            TreeNode leftNodes = root.left;
            while(leftNodes.right!=null)
            {
                leftNodes = leftNodes.right;
            }
            
            TreeNode rightNodes = root.right;
            root.right = root.left;
            root.left = null;
            leftNodes.right= rightNodes;
        }
    }
}

//Shorter brilliant solution O(n)   
public class Solution {
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;//So prev.right==root.right
    }
}