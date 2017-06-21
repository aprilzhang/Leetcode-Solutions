/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 /**
109. Convert Sorted List to Binary Search Tree
 Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
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
 //My accepted solution
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
        {
            return null;
        }
        ListNode preSlow = null;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next!=null&&fast.next.next!=null)
        {
            preSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        TreeNode root= new TreeNode(slow.val);
        
        if(preSlow!=null)
        {
            preSlow.next=null;
            root.left= sortedListToBST(head);
        }
        else
        {
           root.left= sortedListToBST(null); 
        }
        root.right= sortedListToBST(slow.next);
        
        return root;
    }
}
//Add tail into the argument to make the solution cleaner
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