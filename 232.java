public class MyQueue {
    private final Stack<Integer> first = new Stack<>();
    private final Stack<Integer> second = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        first.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (second.empty())
            while (!first.empty())
                second.push(first.pop());
        return second.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (second.empty())
            while (!first.empty())
                second.push(first.pop());
        return second.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return first.empty()&&second.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
 
 //Similar solution
 class MyQueue {
    Stack<Integer> queue = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        Stack<Integer> temp = new Stack<Integer>();
        while(!queue.empty()){
            temp.push(queue.pop());
        }
        queue.push(x);
        while(!temp.empty()){
            queue.push(temp.pop());
        }
    }
    
    // Removes the element from in front of queue.
    public int pop() {
        return queue.pop();
    }
    
    // Get the front element.
    public int peek() {
        return queue.peek();
    }
    
    // Return whether the queue is empty.
    public boolean empty() {
        return queue.empty();
    }
}