/**
148. Sort List
Sort a linked list in O(n log n) time using constant space complexity.
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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
        {
          return head;
        }
            
        // step 1. cut the list to two halves
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) 
        {
          prev = slow;
          slow = slow.next;
          fast = fast.next.next;
        }
        prev.next = null;
        
        // step 2. sort each half
        // step 3. merge l1 and l2
        return merge(sortList(head), sortList(slow));
      }
      
      
    private static ListNode merge(ListNode l1, ListNode l2) 
    {
        ListNode l = new ListNode(0);
        ListNode p = l;
        
        while (l1 != null && l2 != null) 
        {
          if (l1.val < l2.val) 
          {
            p.next = l1;
            l1 = l1.next;
          } 
          else 
          {
            p.next = l2;
            l2 = l2.next;
          }
          p = p.next;
        }
        
        if (l1 != null)
          p.next = l1;
        
        if (l2 != null)
          p.next = l2;
        
        return l.next;
      }
}