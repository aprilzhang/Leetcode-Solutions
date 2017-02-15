/**
94. Binary Tree Inorder Traversal
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

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
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        final List<Integer> result = new ArrayList<>();
        if(root==null)
        {
            return result;
        }
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }
}

//iteratively
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        final List<Integer> result = new ArrayList<>();
        final Stack<TreeNode> store = new Stack<>();
        addLeftToStack(store,root);
        while(!store.empty())
        {
            final TreeNode newNode = store.pop();
            result.add(newNode.val);
            addLeftToStack(store,newNode.right);
        }
        return result;
    }
    
    private static void addLeftToStack(Stack store, TreeNode node)
    {
        while(node!=null)
        {
            store.push(node);
            node = node.left;
        }
    }
}