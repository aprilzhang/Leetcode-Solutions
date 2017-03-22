/**
56. Merge Intervals
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
*/
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        final List<Interval> results = new ArrayList<>();
        if(intervals.isEmpty())
        {
            return results;
        }
        Collections.sort(intervals,(i1,i2)->i1.start==i2.start?(i1.end-i2.end):(i1.start-i2.start));
        results.add(intervals.get(0));
        for(int i =1;i<intervals.size();i++)
        {
            final Interval currentInterval = results.get(results.size()-1);
            if(currentInterval.end>=intervals.get(i).start)
            {
                currentInterval.end = Math.max(currentInterval.end,intervals.get(i).end);
            }
            else
            {
                results.add(intervals.get(i));
            }
        }
        return results;
    }
}