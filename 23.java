/**
23. Merge k Sorted Lists
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 // O(nlogk), merge takes O(n) time and partition takes O(logk) time
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return partion(lists,0,lists.length-1);
    }
    
    public static ListNode partion(ListNode[] lists,int start,int end){
        if(start==end)  return lists[start];
        else if(start>end) return null;
        else
        {
            int q=(start+end)/2;
            ListNode l1=partion(lists,start,q);
            ListNode l2=partion(lists,q+1,end);
            return merge(l1,l2);
        }
    }
    
    private static ListNode merge(ListNode l1, ListNode l2)
    {
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val)
        {
            l1.next=merge(l1.next,l2);
            return l1;
        }
        else
        {
            l2.next=merge(l1,l2.next);
            return l2;
        }
    }
}

//Using built-in priority queue
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null) return null;
        
        final PriorityQueue<ListNode> queue= new PriorityQueue<>((o1,o2)->
            (o1.val<o2.val)?-1:((o1.val==o2.val)?0:1));
        
        final ListNode dummy = new ListNode(0);
        ListNode tail=dummy;
        
        for (ListNode node:lists)
        {
            if(node!=null) queue.add(node);
        }
            
        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;
            
            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
}