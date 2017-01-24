/**
366. Find Leaves of Binary Tree
Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

Example:
Given binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Returns [4, 5, 3], [2], [1].

Explanation:
1. Removing the leaves [4, 5, 3] would result in this tree:

          1
         / 
        2          
2. Now removing the leaf [2] would result in this tree:

          1          
3. Now removing the leaf [1] would result in the empty tree:

          []         
Returns [4, 5, 3], [2], [1].
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
    public List<List<Integer>> findLeaves(TreeNode root) {
        final List<List<Integer>> result = new ArrayList<>();
        addAlong(result,root);
        return result;
    }
    
    private static int addAlong(List<List<Integer>> result,TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        if(isLeaf(root))
        {
            return addInto(result,root,0);
        }
        else
        {
            return addInto(result,root,Math.max(addAlong(result,root.left),addAlong(result,root.right)));
        }
    }
    
    private static int addInto(List<List<Integer>> result,TreeNode root, int index)
    {
        if(index==result.size())
        {
            result.add(new ArrayList<Integer>());
        }
        result.get(index).add(root.val);
        return index+1;
    }
    
    private static boolean isLeaf(TreeNode root)
    {
        return root!=null&&root.left == null && root.right == null;
    }
	
	
	
	
	///
	//shorter solution
	    private static int addAlong(List<List<Integer>> result,TreeNode root)
    {
        if(root == null)
        {
            return -1;
        }
        final int rootIndex = 1+Math.max(addAlong(result,root.left),addAlong(result,root.right));
        if(rootIndex==result.size())
        {
            result.add(new ArrayList<Integer>());
        }
        result.get(rootIndex).add(root.val);
        return rootIndex;
    }
}
