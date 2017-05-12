/**
95. Unique Binary Search Trees II
Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/   
//My attempt
	public List<TreeNode> generateTrees(int n) {
        LinkedList<TreeNode> nodes = new LinkedList<>();
        final List<TreeNode> newNodes = new ArrayList<>();
        nodes.push(1);
        int i = 1;
        while(i<n)
        {   
            while(!nodes.isEmpty())
            {
                createNodesFromPrevious(nodes.pop(),i,newNodes);
            }
            nodes.addAll(newNodes);
            newNodes.clear();
        }
        
        return nodes;
    }
    
    
    private List<TreeNode> createNodesFromPrevious(TreeNode node, int newNumber)
    {
        final List<TreeNode> result = new ArrayList<>();
        if(newNumber>node.val)
        {
            TreeNode newNode = new TreeNode(newNumber);
            newNode.left = node;
            result.add(newNode);
            
            for(TreeNode n:createNodesFromPrevious(node.right,newNumber))
            {
                
            }
        }
    }
	
//Recursive solution
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
    public List<TreeNode> generateTrees(int n) {
        
        if(n==0)
        {
            return new ArrayList<TreeNode>();
        }
        return genTrees(1,n);
    }
        
    public List<TreeNode> genTrees (int start, int end)
    {
        List<TreeNode> list = new ArrayList<TreeNode>();

        if(start>end)
        {
            list.add(null);
            return list;
        }
        
        if(start == end){
            list.add(new TreeNode(start));
            return list;
        }
        
        List<TreeNode> left,right;
        for(int i=start;i<=end;i++)
        {
            
            left = genTrees(start, i-1);
            right = genTrees(i+1,end);
            
            for(TreeNode lnode: left)
            {
                for(TreeNode rnode: right)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    list.add(root);
                }
            }
                
        }
        
        return list;
    }
}

//DP solution
//Slightly faster
//result[i] stores the result until length i. For the result for length i+1, select the root node j from 0 to i, combine the result from left side and right side. Note for the right side we have to clone the nodes as the value will be offsetted by j.
public class Solution {
    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] result = new List[n + 1];
        result[0] = new ArrayList<TreeNode>();
        if (n == 0) {
            return result[0];
        }
    
        result[0].add(null);
        for (int len = 1; len <= n; len++) {
            result[len] = new ArrayList<TreeNode>();
            for (int j = 0; j < len; j++) {
                for (TreeNode nodeL : result[j]) {
                    for (TreeNode nodeR : result[len - j - 1]) {
                        TreeNode node = new TreeNode(j + 1);
                        node.left = nodeL;
                        node.right = clone(nodeR, j + 1);
                        result[len].add(node);
                    }
                }
            }
        }
        return result[n];
    }
    
    private static TreeNode clone(TreeNode n, int offset) {
        if (n == null) {
            return null;
        }
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }
}