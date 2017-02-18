/**
323. Number of Connected Components in an Undirected Graph
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.

Example 1:
     0          3
     |          |
     1 --- 2    4
Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

Example 2:
     0           4
     |           |
     1 --- 2 --- 3
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

Note:
You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
*/
public class Solution {
    public int countComponents(int n, int[][] edges) {
        final Map<Integer, Set<Integer>> minSides = new HashMap<>();
        for(int[] edge:edges)
        {
            Set<Integer> existingOnes  = minSides.get(edge[0]);
            if(existingOnes==null)
            {
                existingOnes = new HashSet<Integer>();
                minSides.put(edge[0],existingOnes);
            }
            existingOnes.add(edge[1]);
            Set<Integer> existingTwos  = minSides.get(edge[1]);
            if(existingTwos==null)
            {
                existingTwos = new HashSet<Integer>();
                minSides.put(edge[1],existingTwos);
            }
            existingTwos.add(edge[0]);
        }
        
        final LinkedList<Integer> values = new LinkedList<>();
        for(int i =0;i<n;i++)
        {
            values.add(i);
        }
        int count=0;
        while(values.size()!=0)
        {
            findLinkedValues(values.peek(),minSides,values);
            count++;
        }
        return count;
    }
    
    private void findLinkedValues(int value, Map<Integer, Set<Integer>> minSides,LinkedList<Integer> values)
    {
        if(values.remove(Integer.valueOf(value))&&minSides.containsKey(value))
        {
            for(int connectedValue:minSides.get(value))
            {   
                findLinkedValues(connectedValue,minSides,values);
            }
        }
    }
}

//Improvements
public class Solution {
    public int countComponents(int n, int[][] edges) {
        final boolean[][] connections = new boolean[n][n];
        for(int[] edge:edges)
        {
            connections[edge[0]][edge[1]] = true;
            connections[edge[1]][edge[0]] = true;
        }
        
        final LinkedList<Integer> values = new LinkedList<>();
        for(int i =0;i<n;i++)
        {
            values.add(i);
        }
        
        int count=0;
        while(values.size()!=0)
        {
            findLinkedValues(values.peek(),connections,values);
            count++;
        }
        return count;
    }
    
    private void findLinkedValues(int value, boolean[][] connections,LinkedList<Integer> values)
    {
        if(values.remove(Integer.valueOf(value)))
        {
            final boolean[] connected = connections[value];
            for(int i =0;i<connected.length;i++)
            {   
                if(connected[i])
                {
                    findLinkedValues(i,connections,values);
                }
            }
        }
    }
}

//Best solution
//Number of island
public class Solution {
    public int countComponents(int n, int[][] edges) 
    {
        final int[] roots = new int[n];
        //Roots are themselves at the beginning
        for(int i = 0; i < n; i++)
        {
            roots[i] = i; 
        }
    
        int count = n;
        for(int[] e : edges) {
            int root1 = findRootId(roots, e[0]);
            int root2 = findRootId(roots, e[1]);
            if(root1 != root2) {      
                roots[root1] = root2;  // union
                count--;
            }
        }
        return count;
    }
    
    public int findRootId(int[] roots, int id) 
    {
        while(roots[id] != id) {
            roots[id] = roots[roots[id]];  // optional: path compression
            id = roots[id];
        }
        return id;
    }
}