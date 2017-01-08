/**
346. Moving Average from Data Stream
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

For example,
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
*/
public class MovingAverage {
    private final List<Integer> values = new ArrayList<>();
    private final int windowSize;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.windowSize = size;
    }
    
    public double next(int val) {
        values.add(0,val);
        int count = Math.min(windowSize,values.size());
        double sum = 0;
        for(int i =0; i<count;i++)
        {
            sum+=values.get(i);
        }
        return sum/count;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */