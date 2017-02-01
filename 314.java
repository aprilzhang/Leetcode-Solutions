/**
314. Binary Tree Vertical Order Traversal
Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples:

Given binary tree [3,9,20,null,null,15,7],
   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7
return its vertical order traversal as:
[
  [9],
  [3,15],
  [20],
  [7]
]
Given binary tree [3,9,8,4,0,1,7],
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
return its vertical order traversal as:
[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]
Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2
return its vertical order traversal as:
[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]
Show Company Tags
Show Tags
Show Similar Problems

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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        final List<List<Integer>> list = new ArrayList<>();
        if(root == null)
        {
            return list;
        }
        //Initialise solution list.
        final int depth = depth(root);
        final int columns = depth+depth-1;
        final int mid = depth-1;
        for(int i = 0;i<columns;i++)
        {
            list.add(new ArrayList<Integer>());
        }
        
        //BFS
       final Queue<TreeNode> queue = new LinkedList<>();
       final Queue<Integer> cols = new LinkedList<>();
        
        queue.add(root);
        cols.add(mid);
        
        while(!queue.isEmpty())
        {
            final TreeNode node = queue.poll();
            final int col = cols.poll();
            list.get(col).add(node.val);
            
            if(node.left!=null)
            {
                queue.add(node.left);
                cols.add(col-1);
            }            
            if(node.right!=null)
            {
                queue.add(node.right);
                cols.add(col+1);
            }
        }
        //filter nonempty busket 
        final List<List<Integer>> solution = new ArrayList<>();
        for(List<Integer> l:list)
        {
            if(!l.isEmpty())
            {
                solution.add(l);
            }
        }
        return solution;
    }
    
    private static int depth(TreeNode root)
    {
        return root==null?0:(1+Math.max(depth(root.left),depth(root.right)));
    }
}