/**
199. Binary Tree Right Side View
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
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
    public List<Integer> rightSideView(TreeNode root) {
        final List<Integer> result = new ArrayList<>();
        if(root == null)
        {
            return result;
        }
        LinkedList<TreeNode> upperLevel = new LinkedList<>();
        LinkedList<TreeNode> currentLevel = new LinkedList<>();
        upperLevel.add(root);
        result.add(root.val);
        while(upperLevel.size()>0)
        {
            TreeNode node = upperLevel.pop();
            if(node.right!=null)
            {
                currentLevel.add(node.right);
            }
            if(node.left!=null)
            {
                currentLevel.add(node.left);
            }
            if(upperLevel.size()==0&&currentLevel.size()>0)
            {
                result.add(currentLevel.peek().val);
                upperLevel = currentLevel;
                currentLevel = new LinkedList<>();
            }
        }
        return result;
    }
}

//Better solution
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }
    
    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }
        
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
        
    }
}