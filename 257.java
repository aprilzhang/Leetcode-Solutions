/**
257. Binary Tree Paths
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
*/

//My solution
//Slow
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
    public List<String> binaryTreePaths(TreeNode root) {
        final List<String> result = new ArrayList<>();
        if(root==null)
        {
            return result;
        }
        //leaf node
        if(root.left==null&&root.right==null)
        {
            result.add(root.val+"");
            return result;
        }
        
        for(String prev:binaryTreePaths(root.left))
        {
            result.add(root.val+"->"+prev);
        }
        
        for(String prev:binaryTreePaths(root.right))
        {
            result.add(root.val+"->"+prev);
        }
        return result;
    }
}

//Faster way
public class Solution {
    
    public List<String> binaryTreePaths(TreeNode root) {
        final List<String> result = new ArrayList<>();
        if(root==null)
        {
            return result;
        }
        
        binaryTreePathsHelper(result,"",root);
        return result;
    }
    public void binaryTreePathsHelper(List<String> result, String path, TreeNode root) {
        //leaf node
        if(root.left==null&&root.right==null)
        {
            result.add(path+root.val);
            return;
        }
        
        if(root.left!=null)
        {
            binaryTreePathsHelper(result,path+root.val+"->",root.left);
        }
        if(root.right!=null)
        {
            binaryTreePathsHelper(result,path+root.val+"->",root.right);
        }
    }
}