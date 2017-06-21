/**
107. Binary Tree Level Order Traversal II
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        final LinkedList<List<Integer>> result = new LinkedList<>();
        if(root ==null)
        {
            return result;
        }
        
        result.addFirst(Arrays.asList(root.val));
        
        ArrayList<TreeNode> upperLayer = new ArrayList<>();
        upperLayer.add(root);
        while(!upperLayer.isEmpty())
        {
            final ArrayList<TreeNode> currentLayer = new ArrayList<>();
            final ArrayList<Integer> currentValues = new ArrayList<>();
            for(int i = 0;i<upperLayer.size();i++)
            {
                final TreeNode node = upperLayer.get(i);
                if(node.left!=null)
                {
                   currentLayer.add(node.left);
                   currentValues.add(node.left.val);
                }
                if(node.right!=null)
                {
                   currentLayer.add(node.right); 
                   currentValues.add(node.right.val);
                }
            }
            if(!currentValues.isEmpty())
            {
                result.addFirst(currentValues);
            }
            upperLayer = currentLayer;
        }
        return result;
    }
}

//Slight refactor to only create one list of treeNodes
//Pretty fast, beats 70%
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        final LinkedList<List<Integer>> result = new LinkedList<>();
        if(root ==null)
        {
            return result;
        }
        
        result.addFirst(Arrays.asList(root.val));
        
        final ArrayList<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        
        int i =0;
        while(i<nodes.size())
        {
            final ArrayList<Integer> currentValues = new ArrayList<>();
            final int levelEnd = nodes.size();
            while(i<levelEnd)
            {
                final TreeNode node = nodes.get(i);
                if(node.left!=null)
                {
                   nodes.add(node.left);
                   currentValues.add(node.left.val);
                }
                if(node.right!=null)
                {
                   nodes.add(node.right); 
                   currentValues.add(node.right.val);
                }
                i++;
            }
            if(!currentValues.isEmpty())
            {
                result.addFirst(currentValues);
            }
        }
        return result;
    }
}


//BFS solution
//Slow
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        levelMaker(result, root, 0);
        return result;
    }
        
    public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
        if(root == null) return;
        if(level >= list.size()) {
            list.add(0, new LinkedList<Integer>());
        }
        levelMaker(list, root.left, level+1);
        levelMaker(list, root.right, level+1);
        list.get(list.size()-level-1).add(root.val);
    }
}
