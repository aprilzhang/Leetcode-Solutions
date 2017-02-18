/**
356. Line Reflection
Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.

Example 1:
Given points = [[1,1],[-1,1]], return true.

Example 2:
Given points = [[1,1],[-1,-1]], return false.

Follow up:
Could you do better than O(n2)?

Hint:

Find the smallest and largest x-value for all points.
If there is a line then it should be at y = (minX + maxX) / 2.
For each point, make sure that it has a reflected point in the opposite side.
*/
public class Solution {
    public boolean isReflected(int[][] points) {
        final Map<Integer,Set<Integer>> xsInSameY = new HashMap<>();
         for(int[] point:points)
         {
             if(xsInSameY.containsKey(point[1]))
             {
                 xsInSameY.get(point[1]).add(point[0]);
             }
             else
             {
                 final Set<Integer> newList = new HashSet<>();
                 newList.add(point[0]);
                 xsInSameY.put(point[1],newList);
             }
         }
         
         double symmetric = Double.NaN;
         for(Set<Integer> xs:xsInSameY.values())
         {
             double mid = symmetryBy(xs);
             if(Double.isNaN(mid))
             {
                 return false;
             }
             else if(Double.isNaN(symmetric))
             {
                 symmetric = mid;
             }
             else if(symmetric!=mid)
             {
                 return false;
             }
         }
         return true;
    }
    
    private double symmetryBy(Set<Integer> xs)
    {
        double min = Integer.MAX_VALUE;
        double max = Integer.MIN_VALUE;
        double sum = 0;
        for(int x:xs)
        {
            min = Math.min(min,x);
            max = Math.max(max,x);
            sum+=x;
        }
        
        final double mid = (min+max)/2;
        if(sum/xs.size()==mid)
        {
            return mid;
        }
        else
        {
            return Double.NaN;
        }
    }
}

//Using hashcode
public class Solution {
    public boolean isReflected(int[][] points) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        final HashSet<Integer> pointSet = new HashSet<>();
        
         for(int[] point:points)
         {
            min = Math.min(min,point[0]);
            max = Math.max(max,point[0]);
            pointSet.add(Arrays.hashCode(point));
         }
         
        final int sum = max+min;
        for(int[] point:points) 
        {
            final int[] opposite= {sum-point[ 0 ], point[ 1 ]};
            if(!pointSet.contains(Arrays.hashCode(opposite))) 
            {
                return false;
            }
        }
        return true;
    }
}