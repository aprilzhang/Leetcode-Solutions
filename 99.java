/**
 99. Recover Binary Search Tree
 Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
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

 
 //My solution slow
public class Solution {
    public void recoverTree(TreeNode root) {
        final List<TreeNode> nodes = treeIntoList(root);
        
        int small=0;
        int large=0;
        int i =1;
        while(i<nodes.size())
        {
            if(nodes.get(i).val<nodes.get(i-1).val)
            {
                large = i-1;
                small=i;
                i++;
                break;
            }
            i++;
        }
        while(i<nodes.size())
        {
            if(nodes.get(i).val<nodes.get(i-1).val)
            {
                small = i;
                break;
            }
            i++;
        }
        final int temp = nodes.get(small).val;
        nodes.get(small).val = nodes.get(large).val;
        nodes.get(large).val = temp;
    }
    
    
    private static List<TreeNode> treeIntoList(TreeNode root)
    {
        final List<TreeNode> result = new ArrayList<>();
        if(root==null)
        {
            return result;
        }
        
        result.addAll(treeIntoList(root.left));
        result.add(root);
        result.addAll(treeIntoList(root.right));
        return result;
    }
} 
//Much better solution
public class Solution {
    TreeNode firstElement = null;
    TreeNode secondElement = null;
    // The reason for this initialization is to avoid null pointer exception in the first comparison when prevElement has not been initialized
    TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);
    
    public void recoverTree(TreeNode root) {
        
        // In order traversal to find the two elements
        traverse(root);
        
        // Swap the values of the two nodes
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }
    
    private void traverse(TreeNode root) {
        
        if (root == null)
            return;
            
        traverse(root.left);
        
        // Start of "do some business", 
        // If first element has not been found, assign it to prevElement (refer to 6 in the example above)
        if (firstElement == null && prevElement.val >= root.val) {
            firstElement = prevElement;
        }
    
        // If first element is found, assign the second element to the root (refer to 2 in the example above)
        if (firstElement != null && prevElement.val >= root.val) {
            secondElement = root;
        }        
        prevElement = root;

        // End of "do some business"

        traverse(root.right);
    }
}