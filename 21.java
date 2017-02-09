/**
21. Merge Two Sorted Lists
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        final ListNode head = new ListNode(0);
        ListNode resultNode = head;
        ListNode node1 = l1;
        ListNode node2 = l2;
        while(l1!=null&&l2!=null)
        {
            if(l1.val>l2.val)
            {
                resultNode.next =new ListNode(l2.val);
                l2 = l2.next;
            }
            else
            {
                resultNode.next =new ListNode(l1.val);
                l1 = l1.next;
            }
            resultNode = resultNode.next;
        }
        if(l1!=null)
        {
            resultNode.next = l1;
        }
        else if(l2!=null)
        {
            resultNode.next = l2;
        }
        return head.next;
    }
}

//Recursive solution
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
        {
            return l2;
        }
        else if(l2==null)
        {
            return l1;
        }
        else
        {
            final ListNode head;
            if(l1.val>l2.val)
            {
                head =new ListNode(l2.val);
                head.next = mergeTwoLists(l1,l2.next);
            }
            else
            {
                head =new ListNode(l1.val);
                head.next = mergeTwoLists(l1.next,l2);
            }
            return head;
        }
    }