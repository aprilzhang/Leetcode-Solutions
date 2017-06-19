/**
145. Binary Tree Postorder Traversal
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
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
    public List<Integer> postorderTraversal(TreeNode root) {
        final List<Integer> result = new ArrayList<>();
        if(root==null)
        {
            return result;
        }
        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);
        return result;
    }
}
//Iterative solution
//Hard
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        final LinkedList<Integer> result = new LinkedList<>();
        if(root==null)
        {
            return result;
        }
        final Stack<TreeNode> stack = new Stack<>();
        
        stack.push(root);
        
    	while (!stack.empty()) {
    		TreeNode cur = stack.pop();
    		result.addFirst(cur.val);
    		if (cur.left != null) {
    			stack.push(cur.left);
    		}
    		if (cur.right != null) {
    			stack.push(cur.right);
    		} 
    	}
        return result;
    }
}