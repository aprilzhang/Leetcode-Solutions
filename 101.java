/**
101. Symmetric Tree
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
*/
//My attempt, actually almost there!!!!
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
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
        {
            return true;
        }
        Stack<TreeNode> leftDfs = new Stack<>();
        if(root.left!=null)
        {
            leftDfs.push(root.left);
        }
        Stack<TreeNode> rightDfs = new Stack<>();
        if(root.right!=null)
        {
            rightDfs.push(root.right);
        }
        
        while(!leftDfs.empty()&&!rightDfs.empty())
        {
            TreeNode left = leftDfs.pop();
            TreeNode right = rightDfs.pop();
            
            if(left.val!=right.val)
            {
                return false;
            }
            if(left.left!=null&&right.right!=null)
            {
                leftDfs.push(left.left);
                rightDfs.push(right.right);
            }
            if(left.right!=null&&right.left!=null)
            {
                leftDfs.push(left.right);
                rightDfs.push(right.left);
            }
            if(left.left==null&&right.right==null&&left.right==null&&right.left==null)
            {
                leftDfs.pop();
                rightDfs.pop();
            }
            else
            {
                return false;
            }
        }
        return leftDfs.empty()&&rightDfs.empty();
    }
}

//Iterative solution
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
        {
            return true;
        }
        Stack<TreeNode> leftBFS = new Stack<>();
        if(root.left!=null)
        {
            leftBFS.push(root.left);
        }
        Stack<TreeNode> rightBFS = new Stack<>();
        if(root.right!=null)
        {
            rightBFS.push(root.right);
        }
        
        while(!leftBFS.empty()&&!rightBFS.empty())
        {
            TreeNode left = leftBFS.pop();
            TreeNode right = rightBFS.pop();
            
            if(left.val!=right.val)
            {
                return false;
            }
            if(left.left!=null)
            {
                if(right.right==null) return false;
                leftBFS.push(left.left);
                rightBFS.push(right.right);
            }
            else if(right.right!=null)
            {
                return false;
            }
            if(left.right!=null)
            {
                if(right.left==null) return false;
                leftBFS.push(left.right);
                rightBFS.push(right.left);
            }
            else if(right.left!=null)
            {
                return false;
            }
        }
        return leftBFS.empty()&&rightBFS.empty();
    }
}

//Recursive solution
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
        {
            return true;
        }
        return isSymmetricHelper(root.left,root.right);
    }
    
    private boolean isSymmetricHelper(TreeNode left,TreeNode right)
    {
        if(left==null || right==null)
        {
            return left==right;
        }
        return left.val==right.val&&isSymmetricHelper(left.left,right.right)&&isSymmetricHelper(left.right,right.left);
    }
}