/¡Á¡Á
252. Meeting Rooms
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return false.
¡Á/
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
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals.length==0)
        {
            return true;
        }
        final TreeNode root = new TreeNode(intervals[0]);
        for(int i =1;i<intervals.length;i++)
        {
            final TreeNode newNode = new TreeNode(intervals[i]);
            if(!insert(newNode,root))
            {
               return false; 
            }
        }
        return true;
    }
    
    private boolean insert(TreeNode newNode, TreeNode node)
    {
        if(newNode.interval.start<node.interval.start)
        {
            if(newNode.interval.end<=node.interval.start)
            {
                if(node.left==null)
                {
                    node.left=newNode;
                return true;
                }
                else
                {
                  return insert(newNode,node.left);
                }
            }
            else
            {
                return false;
            }
        }
        else
        {
            if(newNode.interval.start>=node.interval.end)
            {
                if(node.right==null)
                {
                    node.right=newNode;
                return true;
                }
                else
                {
                return insert(newNode,node.right);
                }
            }
            else
            {
                return false;
            }
        }
    }
    
    
    private class TreeNode {
     TreeNode left;
    TreeNode right;
     Interval interval;
      TreeNode(Interval interval) { this.interval=interval;}
}
}