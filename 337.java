/**
337. House Robber III
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:
     3
    / \
   2   3
    \   \ 
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
     3
    / \
   4   5
  / \   \ 
 1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.
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
    public int rob(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        
        //If rob root
        int robRoot = root.val;
        if(root.left!=null)
        {
            robRoot+=rob(root.left.left)+rob(root.left.right);
        }
        if(root.right!=null)
        {
            robRoot+=rob(root.right.left)+rob(root.right.right);
        }
        
        //If do not rob root
        final int leaveRoot = rob(root.left)+rob(root.right);
        
        return Math.max(robRoot,leaveRoot);
    }
}
//Slightly faster solution, store the value in map
//O(n)
public class Solution {
    public int rob(TreeNode root) {
        return robHelper(root,new HashMap<TreeNode, Integer>());
    }
    
    private int robHelper(TreeNode root, Map<TreeNode, Integer> map) {
        if(root==null)
        {
            return 0;
        }
        
        if (map.containsKey(root))
        {
            return map.get(root);
        }
        
        //If rob root
        int robRoot = root.val;
        if(root.left!=null)
        {
            robRoot+=robHelper(root.left.left,map)+robHelper(root.left.right,map);
        }
        if(root.right!=null)
        {
            robRoot+=robHelper(root.right.left,map)+robHelper(root.right.right,map);
        }
        
        //If do not rob root
        final int leaveRoot = robHelper(root.left,map)+robHelper(root.right,map);
        final int val =  Math.max(robRoot,leaveRoot);
        
        map.put(root, val);
        
        return val;
    }
}

//Even faster solution
//A bit like calculating factorial
public class Solution {
    public int rob(TreeNode root) {
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }
    
    //[0] the maximum amount of money that can be robbed if root is not robbed
    //[1] the maximum amount of money that can be robbed if root is robbed
    private int[] robSub(TreeNode root) {
        if (root == null) return new int[2];
        
        int[] left = robSub(root.left);
        int[] right = robSub(root.right);
        int[] res = new int[2];
    
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        
        return res;
    }
}