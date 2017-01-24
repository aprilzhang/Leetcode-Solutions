/**
369. Plus One Linked List
Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.

Example:
Input:
1->2->3

Output:
1->2->4
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        if(loop(head))
        {
            final ListNode newHead = new ListNode(1);
            newHead.next= head;
            head = newHead;
        }
        return head;
    }
    
    private static boolean loop(ListNode root) 
    {       
        if(root==null)
        {
            return false;
        }
        if(root.next==null||loop(root.next))
        {
            root.val +=1; 
            if(root.val ==10)
            {
                root.val = 0;
                return true;
            }
        }
        return false;
    }
	
	
	//Iterative solution
	public class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode i = dummy;
        ListNode j = dummy;

        while (j.next != null) {
            j = j.next;
            if (j.val != 9) {
                i = j;
            }
        }
        // i = index of last non-9 digit
    
        i.val++;
        i = i.next;
        while (i != null) {
            i.val = 0;
            i = i.next;
        }
        
        if (dummy.val == 0) return dummy.next;
        return dummy;
    }
}
}