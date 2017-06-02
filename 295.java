/**
295. Find Median from Data Stream
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Examples: 
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
For example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2
*/
//My solution slow
public class MedianFinder {
    private final List<Double> numbers = new ArrayList<>();
    private int count = 0;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        int lower = 0;
        int upper = count;
        while(lower<upper)
        {
            int mid = (lower+upper)/2;
            if(numbers.get(mid)<num)
            {
                lower = mid+1;
            }
            else if(numbers.get(mid)>num)
            {
                upper = mid;
            }
            else
            {
                lower = mid;
                break;
            }
        }
        numbers.add(lower,(double)num);
        count++;
    }
    
    public double findMedian() {
        if(count==0)
        {
            return 0;
        }
        else if(count%2==0)
        {
            return (numbers.get(count/2-1)+numbers.get(count/2))/2;
        }
        else
        {
            return numbers.get(count/2);
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
 
 //faster solution
 // priority queue implements heap
 class MedianFinder {
    private final PriorityQueue<Double> small = new PriorityQueue<>();
    private final PriorityQueue<Double> large = new PriorityQueue<>();
    
    /** initialize your data structure here. */
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        //Supporting both min- and max-heap is more or less cumbersome, 
        // so simply negate the numbers
        large.add((double) num);
        small.add(-large.poll());
        if (large.size() < small.size())
        {
            large.add(-small.poll());
        }
    }
    
    public double findMedian() {
        return large.size() > small.size()
               ? large.peek()
               : (large.peek() - small.peek()) / 2.0;
    }
}
