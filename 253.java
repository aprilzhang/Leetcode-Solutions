/**
253. Meeting Rooms II
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.
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
 //If the range is small
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(Interval interval:intervals)
        {
            min = Math.min(min,interval.start);
            max = Math.max(max,interval.end);
        }
        final int[] rooms = new int[max+1];
        for(int i = 0;i<intervals.length;i++)
        {
            rooms[intervals[i].start]++;
            rooms[intervals[i].end]--;
        }
        
        int maxRooms = 0;
        for(int i =1;i<rooms.length;i++)
        {
            rooms[i]+=rooms[i-1];
            maxRooms = Math.max(maxRooms,rooms[i]);
        }
        return maxRooms;
    }
}

//O(nlogn) most time faster
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i=0; i<intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0;
        int endsItr = 0;
        for(int i=0; i<starts.length; i++) {
            if(starts[i]<ends[endsItr])
                rooms++;
            else
                endsItr++;
        }
        return rooms;
    }
}