/**
19. Remove Nth Node From End of List
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        int count;
        for(count = 0;fast!=null&& count<=n;count++)
        {
            fast = fast.next;
        }
        
        if(count==n)
        {
            return head.next;
        }
        
        ListNode slow = head;
        while(fast!=null)
        {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next =slow.next.next;
        return head;
    }
}