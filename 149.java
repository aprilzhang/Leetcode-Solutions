 /** 
 149. Max Points on a Line
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
*/
  /*
     *  A line is determined by two factors,say y=ax+b
     *  
     *  If two points(x1,y1) (x2,y2) are on the same line(Of course). 

     *  Consider the gap between two points.

     *  We have (y2-y1)=a(x2-x1),a=(y2-y1)/(x2-x1) a is a rational, b is canceled since b is a constant

     *  If a third point (x3,y3) are on the same line. So we must have y3=ax3+b

     *  Thus,(y3-y1)/(x3-x1)=(y2-y1)/(x2-x1)=a

     *  Since a is a rational, there exists y0 and x0, y0/x0=(y3-y1)/(x3-x1)=(y2-y1)/(x2-x1)=a

     *  So we can use y0&x0 to track a line;
     */

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if(points==null)
        {
            return 0;
        }
        if(points.length <= 2) 
        {
            return points.length;
        }
        
        int result = 0;
        for(int i = 0; i < points.length; i++)
        {
            // first option would be store gradient, but doubles does not work well.
            // so store the min integer factors
            //{x,y,count}
            final Map<Integer,Map<Integer,Integer>> map = new HashMap<>();
            int samePoint = 0;
            int max = 0;
            for(int j = i+1; j < points.length; j++)
            {
                int xDiff =points[j].x-points[i].x;
        		int yDiff =points[j].y-points[i].y;
                if(xDiff==0&&yDiff==0)
                {
                    samePoint++;
                    continue;
                }
                final int gcd=generateGCD(xDiff,yDiff);
    			if (gcd!=0){
    				xDiff/=gcd;
    				yDiff/=gcd;
    			}
    			
    			if (map.containsKey(xDiff))
    			{
    				if (map.get(xDiff).containsKey(yDiff))
    				{
    					map.get(xDiff).put(yDiff, map.get(xDiff).get(yDiff)+1);
    				}else
    				{
    					map.get(xDiff).put(yDiff, 1);
    				}  
    			}
    			else
    			{
    				Map<Integer,Integer> m = new HashMap<>();
    				m.put(yDiff, 1);
    				map.put(xDiff, m);
        		}
        		max=Math.max(max, map.get(xDiff).get(yDiff));
            }
            result = Math.max(result, max+samePoint+1);
        }
        return result;
    }
    private static int generateGCD(int a,int b)
    {
    	return b==0?a:generateGCD(b,a%b);
    }
}