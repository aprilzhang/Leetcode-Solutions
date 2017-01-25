/**
296. Best Meeting Point
A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

For example, given three people living at (0,0), (0,4), and (2,2):

1 - 0 - 0 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.
*/
public class Solution {
    public int minTotalDistance(int[][] grid) {
        final List<int[]> people = new ArrayList<>();
        for(int i = 0;i<grid.length;i++)
        {
            for(int j = 0;j<grid[i].length;j++)
            {
                if(grid[i][j]==1)
                {
                    people.add(new int[]{i,j});
                }
            }
        }
        
        int totalDistance = 0;
        for(int i = 0; i<2;i++)
        {
            totalDistance+=minDistance(people,i);
        }
        return totalDistance;
    }
    
    public int minDistance(List<int[]> people, int index)
    {        
        people.sort((a,b)->a[index]-b[index]);
        int i =0; 
        int j =people.size()-1;
        int distance = 0;
        while(i<j)
        {
            distance += people.get(j)[index]-people.get(i)[index];
            i++;
            j--;
        }
        return distance;
    }
}


// Slight modification to speed up
public class Solution {
    public int minTotalDistance(int[][] grid) {
        final List<Integer> I = new ArrayList<>();
        final List<Integer> J = new ArrayList<>();
        for(int i = 0;i<grid.length;i++)
        {
            for(int j = 0;j<grid[i].length;j++)
            {
                if(grid[i][j]==1)
                {
                    I.add(i);
                    J.add(j);
                }
            }
        }
        return minDistance(I)+minDistance(J);
    }
    
    public int minDistance(List<Integer> input)
    {        
         Collections.sort(input);
        int i =0; 
        int j =input.size()-1;
        int distance = 0;
        while(i<j)
        {
            distance += input.get(j)-input.get(i);
            i++;
            j--;
        }
        return distance;
    }
}