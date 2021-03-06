/**
155. Min Stack
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
*/
public class MinStack {
    private final List<Integer> data = new ArrayList<>();
    private final List<Integer> minToLast = new ArrayList<>();
    private int size = 0;

    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        data.add(x);
        minToLast.add(size==0?x:Math.min(x,minToLast.get(size-1)));
        size++;
    }
    
    public void pop() {
        if(size==0)
        {
            throw new AssertionError();
        }
        data.remove(size-1);
        minToLast.remove(size-1);
        size--;
    }
    
    public int top() {
        if(size==0)
        {
            throw new AssertionError();
        }
        return data.get(size-1);
    }
    
    public int getMin() {
        if(size==0)
        {
            throw new AssertionError();
        }
        return minToLast.get(size-1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// Using one stack, this is slower
class MinStack {
    private final Stack<Integer> stack = new Stack<>();
    private int min = Integer.MAX_VALUE;
    
    public void push(int x) {
        // only push the old minimum value when the current 
        // minimum value changes after pushing the new value x
        if(x <= min){          
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value, 
        // pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min) min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}