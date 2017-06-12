/**
116. Populating Next Right Pointers in Each Node
Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
	*/
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
//My solution
//Accepted the first time!!!
//My solution is over complecated, the condition is the tree is perfect balanced
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root ==null)
        {
            return;
        }
        TreeLinkNode currentLevel = root;
        TreeLinkNode nextHeader = null;
        TreeLinkNode nextLevel = nextHeader;
        while(true)
        {
            while(currentLevel!=null)
            {
                if(currentLevel.left!=null)
                {
                    if(nextHeader==null)
                    {
                        nextLevel = currentLevel.left;
                        nextHeader = nextLevel;
                    }
                    else
                    {
                        nextLevel.next = currentLevel.left;
                        nextLevel = nextLevel.next;
                    }
                }
                if(currentLevel.right!=null)
                {
                    if(nextHeader==null)
                    {
                        nextLevel = currentLevel.right;
                        nextHeader = nextLevel;
                    }
                    else
                    {
                        nextLevel.next = currentLevel.right;
                        nextLevel = nextLevel.next;
                    }
                }
                currentLevel = currentLevel.next;
            }
            if(nextHeader==null)
            {
                return;
            }
            currentLevel = nextHeader;
            nextHeader = null;
            nextLevel = null;
        }
    }
}

//Standard solution
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root ==null)
        {
            return;
        }
        TreeLinkNode pre = root;
        TreeLinkNode cur = null;
        while(pre.left!=null)
        {
            cur = pre;
            while(cur!=null)
            {
                cur.left.next = cur.right;//you can assume this
                if(cur.next!=null)
                {
                    cur.right.next = cur.next.left;//you can assume this
                }
                cur = cur.next;
            }
            pre = pre.left;
        }
    }
}