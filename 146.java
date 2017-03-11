/**
146. LRU Cache
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 {capacity}  );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
*/
public class LRUCache {

    private ConcurrentHashMap<Integer, DoubleLinkedNode>  cache = new ConcurrentHashMap<>();
    private int count;
    private int capacity;
    private DoubleLinkedNode head = new DoubleLinkedNode();
    private DoubleLinkedNode tail = new DoubleLinkedNode();
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.post = tail;
	    tail.pre = head;
    }
    
    public int get(int key) {
        final DoubleLinkedNode node = cache.get(key);
    	if(node == null){
    		return -1; // should raise exception here.
    	}
    	
    	// move the accessed node to the head;
    	moveToHead(node);
    	
    	return node.value;
    }
    
    public void put(int key, int value) {
        final DoubleLinkedNode node = cache.get(key);
	
    	if(node != null){
    	    
    		// update the value.
    		node.value = value;
    		moveToHead(node);
    		return;
    	}
    		
		final DoubleLinkedNode newNode = new DoubleLinkedNode();
		newNode.key = key;
		newNode.value = value;
		
		cache.put(key, newNode);
		addNode(newNode);
		
		count++;
		
		if(count > capacity){
			// pop the tail
			final DoubleLinkedNode tail = popTail();
			cache.remove(tail.key);
			count--;
		}
    }
    
    private class DoubleLinkedNode 
    {
    	int key;
    	int value;
    	DoubleLinkedNode pre;
    	DoubleLinkedNode post;
    }
    
    /**
     * Always add the new node right after head;
     */
    private void addNode(DoubleLinkedNode node){
    	node.pre = head;
    	node.post = head.post;
    	
    	head.post.pre = node;
    	head.post = node;
    }
    
    /**
     * Move certain node in between to the head.
     */
    private void moveToHead(DoubleLinkedNode node){
    	removeNode(node);
    	addNode(node);
    }
    
    // pop the current tail. 
    private DoubleLinkedNode popTail(){
    	final DoubleLinkedNode res = tail.pre;
    	removeNode(res);
    	return res;
    }
    
    /**
     * Remove an existing node from the linked list.
     */
    private void removeNode(DoubleLinkedNode node){
    	final DoubleLinkedNode pre = node.pre;
    	final DoubleLinkedNode post = node.post;
    	
    	pre.post = post;
    	post.pre = pre;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */