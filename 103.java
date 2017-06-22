/**
103. Binary Tree Zigzag Level Order Traversal
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
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
//My accepted BFS solution
//Slow though
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        final List<List<Integer>> result = new ArrayList<>();
        if(root==null)
        {
            return result;
        }
        Stack<TreeNode> upperLevel = new Stack<>();
        upperLevel.add(root);
        result.add(Arrays.asList(root.val));
        
        int height = 1;
        while(true)
        {
            final boolean leftToRight = height%2==0;
            final List<Integer> values= new ArrayList<>();
            final Stack<TreeNode> currentLevel = new Stack<>();
            while(!upperLevel.empty())
            {
                TreeNode node = upperLevel.pop();
                if(leftToRight)
                {
                    if(node.left!=null)
                    {
                        currentLevel.add(node.left);
                        values.add(node.left.val);
                    }
                    if(node.right!=null)
                    {
                        currentLevel.add(node.right);
                        values.add(node.right.val);
                    }
                }
                else
                {
                    if(node.right!=null)
                    {
                        currentLevel.add(node.right);
                        values.add(node.right.val);
                    }
                    if(node.left!=null)
                    {
                        currentLevel.add(node.left);
                        values.add(node.left.val);
                    }
                }
            }
            if(!values.isEmpty())
            {
                result.add(values);
                upperLevel = currentLevel;
            }
            else
            {
                break;
            }
            height++;
        }
        return result;
    }
}

//DFS solution
//O(n) solution by using LinkedList along with ArrayList. So insertion in the inner list and outer list are both O(1),
//Using DFS and creating new lists when needed.
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        final List<List<Integer>> result = new ArrayList<>();
        travel(root, result, 0);
        return result;
    }
    
    private void travel(TreeNode curr, List<List<Integer>> result, int level)
    {
        if(curr == null) return;
        
        if(result.size() <= level)
        {
            result.add( new LinkedList<>());
        }
        
        List<Integer> collection  = result.get(level);
        if(level % 2 == 0) collection.add(curr.val);//left to right
        else collection.add(0, curr.val);//right to left
        
        travel(curr.left, result, level + 1);
        travel(curr.right, result, level + 1);
    }
}