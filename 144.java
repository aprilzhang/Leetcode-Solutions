/**
144. Binary Tree Preorder Traversal
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,2,3,4,5,6,7},
   1
  / \
 2   3
/ \  /\
4  5 6 7
return [1,2,4,5,3,6,7].
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
//Recursive solution
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        final List<Integer> result = new ArrayList<>();
        if(root==null)
        {
            return result;
        }
        result.add(root.val);
        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.right));
        return result;
    }
}
//Iterative
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        final List<Integer> result = new ArrayList<>();
        if(root==null)
        {
            return result;
        }
        
        final Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        TreeNode node;
        while(!stack.empty())
        {
            node = stack.pop();
            result.add(node.val);
            if(node.right!=null)  stack.push(node.right);
            if(node.left!=null)  stack.push(node.left);
        }
        return result;
    }
}