/**
138. Copy List with Random Pointer
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
*/
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
        {
            return null;
        }
        final Map<RandomListNode,RandomListNode> nodesMap = new HashMap<>();
        
        RandomListNode node = head;
        while(node!=null)
        {
           nodesMap.put(node,new RandomListNode(node.label));
           node = node.next;
        }
        
        node = head;
        while(node!=null)
        {
           final RandomListNode currentNode = nodesMap.get(node);
           if(node.next!=null)
            {
                currentNode.next = nodesMap.get(node.next);
            }
            if(node.random!=null)
            {
                currentNode.random = nodesMap.get(node.random);
            }
           node = node.next;
        }
        return nodesMap.get(head);
    }
}
//Space O(1) solution
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
    	RandomListNode iter = head, next;
    
    	// First round: make copy of each node,
    	// and link them together side-by-side in a single list.
    	while (iter != null) {
    		next = iter.next;
    
    		RandomListNode copy = new RandomListNode(iter.label);
    		iter.next = copy;
    		copy.next = next;
    
    		iter = next;
    	}
    
    	// Second round: assign random pointers for the copy nodes.
    	iter = head;
    	while (iter != null) {
    		if (iter.random != null) {
    			iter.next.random = iter.random.next;
    		}
    		iter = iter.next.next;
    	}
    
    	// Third round: restore the original list, and extract the copy list.
    	iter = head;
    	RandomListNode pseudoHead = new RandomListNode(0);
    	RandomListNode copy, copyIter = pseudoHead;
    
    	while (iter != null) {
    		next = iter.next.next;
    
    		// extract the copy
    		copy = iter.next;
    		copyIter.next = copy;
    		copyIter = copy;
    
    		// restore the original list
    		iter.next = next;
    
    		iter = next;
    	}
    
    	return pseudoHead.next;
    }
}