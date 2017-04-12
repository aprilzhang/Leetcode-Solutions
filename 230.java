/**
230. Kth Smallest Element in a BST
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 = k = BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

Hint:

Try to utilize the property of a BST.
What if you could modify the BST node's structure?
The optimal runtime complexity is O(height of BST).
*/
//O(n) solution
//Count number of nodes
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
     public int kthSmallest(TreeNode root, int k) {
         Stack<TreeNode> stack = new Stack<TreeNode>();
         TreeNode p = root;
         int count = 0;
         
         while(!stack.isEmpty() || p != null) {
             if(p != null) {
                 stack.push(p);    // Just like recursion
                 p = p.left;   
                 
             } else {
                TreeNode node = stack.pop();
                if(++count == k) return node.val; 
                p = node.right;
             }
         }
         
         return Integer.MIN_VALUE;
     }
}

//O(h) solution
/**
The idea is to maintain rank of each node. We can keep track of elements in a subtree of any node while building the tree. Since we need K-th smallest element, we can maintain number of elements of left subtree in every node.

Assume that the root is having N nodes in its left subtree. If K = N + 1, root is K-th node. If K < N, we will continue our search (recursion) for the Kth smallest element in the left subtree of root. If K > N + 1, we continue our search in the right subtree for the (K – N – 1)-th smallest element. Note that we need the count of elements in left subtree only.

1.travel tree by level and insert node into TreeNodeWithCount Tree.

2.find kth smallest in the TreeNodeWithCount Tree.
*/

public class TreeNodeWithCount {
    int val;
    int lCount;
    TreeNodeWithCount left;
    TreeNodeWithCount right;
    TreeNodeWithCount(int x) { val = x; }
}

public int kthSmallest(TreeNode root, int k) {
    if(root == null) return -1;
    TreeNodeWithCount rootWithCount = createBSTWithCount(root);
    return kthSmallestWithCount(rootWithCount, k);
}

public TreeNodeWithCount createBSTWithCount(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    TreeNodeWithCount rootWithCount = null;
    while(!queue.isEmpty()) {
        TreeNode node = queue.remove();
        TreeNodeWithCount nodeWithCount = new TreeNodeWithCount(node.val);
        rootWithCount = insertBSTWithCount(rootWithCount, nodeWithCount);
        if(node.left != null) queue.add(node.left);
        if(node.right != null) queue.add(node.right);
    }
    return rootWithCount;
}

public TreeNodeWithCount insertBSTWithCount(TreeNodeWithCount rootWithCount, TreeNodeWithCount nodeWithCount) {
    TreeNodeWithCount cur = rootWithCount, parent = rootWithCount;
    while(cur != null) {
        parent = cur;
        if(nodeWithCount.val < cur.val) {
            cur.lCount++;
            cur = cur.left;
        } else {
            cur = cur.right;
        }
    }
    if(rootWithCount == null) {
        rootWithCount = nodeWithCount;
    } else if(nodeWithCount.val < parent.val) {
        parent.left = nodeWithCount;
    } else {
        parent.right = nodeWithCount;
    }
    return rootWithCount;
}

public int kthSmallestWithCount(TreeNodeWithCount rootWithCount, int k) {
    while(rootWithCount != null) {
        if(k == rootWithCount.lCount + 1) {
            return rootWithCount.val;
        } else if(k <= rootWithCount.lCount) {
            rootWithCount = rootWithCount.left;
        } else {
            k = k - rootWithCount.lCount - 1;
            rootWithCount = rootWithCount.right;
        }
    }
    return -1;
}