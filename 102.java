/**
102. Binary Tree Level Order Traversal
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        final List<List<Integer>> result = new ArrayList<>();
        if(root == null)
        {
            return result;
        }
        
        result.add(Arrays.asList(root.val));
        List<TreeNode> pre = Arrays.asList(root);
        
        while(true)
        {
            final List<TreeNode> cur = new ArrayList<>();
            final List<Integer> curVals = new ArrayList<>();
            
            for(TreeNode node:pre)
            {
                if(node.left!=null)
                {
                    cur.add(node.left);
                    curVals.add(node.left.val);
                }
                if(node.right!=null)
                {
                    cur.add(node.right);
                    curVals.add(node.right.val);
                }
            }
            
            if(cur.isEmpty())
            {
                return result;
            }
            
            result.add(curVals);
            pre = cur;
        }
    }
}

//Shorter solution, the time consuming is not shorter!
//Storing all nodes in one list and iterate

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        final List<List<Integer>> result = new ArrayList<>();
        if(root == null)
        {
            return result;
        }
        
        
        final Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while(!queue.isEmpty())
        {
            List<Integer> subList = new LinkedList<Integer>();
            //Queue size changes
            final int levelNum = queue.size();
            for(int i=0; i<levelNum; i++) {
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                subList.add(node.val);
            }
            result.add(subList);
        }
        
        return result;
    }
}

//Another way
//This is faster
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelHelper(res, root, 0);
        return res;
    }
    
    public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height >= res.size()) {
            res.add(new LinkedList<Integer>());
        }
        res.get(height).add(root.val);
        levelHelper(res, root.left, height+1);
        levelHelper(res, root.right, height+1);
    }
}