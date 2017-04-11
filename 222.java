/**
222. Count Complete Tree Nodes
Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
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
 //Basically my solution contains 2 steps.
//(1) Firstly, we need to find the height of the binary tree and count the nodes above the last level.
//(2) Then we should find a way to count the nodes on the last level.
//Here I used a kind of binary search. We define the "midNode" of the last level as a node following the path "root->right->left->left->...->last level".

 //HIGHLIGHT
 // as far left as possible
public class Solution {
    public int countNodes(TreeNode root) {
        final int height = leftHeight(root);
        if(height<0)
        {
            return 0;
        }
        return (leftHeight(root.right)==height-1)
            ?((1<<height)+countNodes(root.right))
            :((1<<(height-1))+countNodes(root.left));
    }
    
    private int leftHeight(TreeNode root)
    {
        return root==null?-1:1+leftHeight(root.left);
    }
}