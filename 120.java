/**
120. Triangle
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle ==null|| triangle.isEmpty())
        {
            return 0;
        }
        
        List<Integer> upperLayer = triangle.get(0);
        for(int i =1;i<triangle.size();i++)
        {
            final List<Integer> currentLayer = new ArrayList<>();
            currentLayer.add(upperLayer.get(0)+triangle.get(i).get(0));
            for(int j = 1;j<triangle.get(i).size()-1;j++)
            {
                currentLayer.add(Math.min(upperLayer.get(j-1),upperLayer.get(j))+triangle.get(i).get(j));
            }
            currentLayer.add(upperLayer.get(upperLayer.size()-1)+triangle.get(i).get(triangle.get(i).size()-1));
            upperLayer = currentLayer;
        }
        
        return upperLayer.stream().min(Comparator.naturalOrder()).get();
    }
}

//Better solution
//Go from bottom to top.
//We start form the row above the bottom row [size()-2].
//Each number add the smaller number of two numbers that below it.
//And finally we get to the top we the smallest sum.
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i = triangle.size() - 2; i >= 0; i--)
        {
            for(int j = 0; j <= i; j++)
            {
                triangle.get(i).set(j, triangle.get(i).get(j) 
                    + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }
}