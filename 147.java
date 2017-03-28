/**
147. Insertion Sort List
Sort a linked list using insertion sort.
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
    public ListNode insertionSortList(ListNode head) {
        ListNode node = head;
        ListNode sorted = null;
        while(node!=null)
        {
            ListNode nextNode = node.next;
            sorted = insertNode(sorted,node);
            node=nextNode;
        }
        return sorted;
    }
    
    private static ListNode insertNode(ListNode sorted, ListNode node)
    {
        if(sorted==null||sorted.val>=node.val)
        {
            node.next = sorted;
            return node;
        }
        ListNode pre = sorted;
        ListNode next = sorted.next;
        while(next!=null&&next.val<node.val)
        {
            pre = pre.next;
            next = next.next;
        }
        pre.next = node;
        node.next = next;
        return sorted;
    }
}