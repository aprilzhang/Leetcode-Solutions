/**
84. Largest Rectangle in Histogram
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given heights = [2,1,5,6,2,3],
return 10.
*/
//Solution is from http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
public class Solution {
    public int largestRectangleArea(int[] height) {
        if(height==null||height.length==0)
        {
            return 0;
        }
        
        final int len = height.length;
        
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++)
        {
            int currentHeight = i < len ? height[i]: 0;
            //If stack is empty or currentHeight is higher than the bar at top of stack, then push ‘i’ to stack.
            if(s.isEmpty() || currentHeight >= height[s.peek()])
            {
                s.push(i);
            }
            // If currentHeight is smaller than the top of stack, then keep removing the top of stack while top of the stack is greater. Let
            // the removed bar be hist[tp]. Calculate area of rectangle with hist[tp] as smallest bar. For hist[tp], the ‘left index’ 
            // is previous (previous to tp) item in stack and ‘right index’ is ‘i’ (current index).
            else
            {
                final int tp = s.pop();
                // Calculate the area with height[tp] stack as smallest bar
                final int width = s.isEmpty() ? i : i - 1 - s.peek();
                maxArea = Math.max(maxArea, height[tp] * width);
                i--;
            }
        }
        return maxArea;
    }
}