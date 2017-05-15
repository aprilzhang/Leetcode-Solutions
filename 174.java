/**
174. Dungeon Game
The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.


Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

-2 (K)	-3	3
-5	-10	1
10	30	-5 (P)

Notes:

The knight's health has no upper bound.
Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
*/

//Correct answer
public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon==null||dungeon.length==0||dungeon[0].length==0)
        {
            return 0;
        }
        
        final int rows = dungeon.length;
        final int columns = dungeon[0].length;
        final int[][] minHealth = new int[rows][columns];
        
        minHealth[rows-1][columns-1] = Math.max(1-dungeon[rows-1][columns-1],1);
        
        for(int i = rows-2;i>=0;i--)
        {
            minHealth[i][columns-1] = Math.max(minHealth[i+1][columns-1]-dungeon[i][columns-1],1);
        }
        for(int j = columns-2;j>=0;j--)
        {
            minHealth[rows-1][j] = Math.max(minHealth[rows-1][j+1]-dungeon[rows-1][j],1);
        }
        
        for(int i = rows-2;i>=0;i--)
        {       
            for(int j = columns-2;j>=0;j--)
            {
                final int up = Math.max(minHealth[i][j+1]-dungeon[i][j],1);
                final int left = Math.max(minHealth[i+1][j]-dungeon[i][j],1); 
                minHealth[i][j] = Math.min(up,left);
            }
        }
        
        return minHealth[0][0];
    }
}

//Wrong solution
public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon==null||dungeon.length==0||dungeon[0].length==0)
        {
            return 0;
        }
        
        final int rows = dungeon.length;
        final int columns = dungeon[0].length;
        final int[][] maxBloodLost = new int[rows][columns];
        final int[][] currentHP = new int[rows][columns];
        
        maxBloodLost[0][0] = dungeon[0][0];
        currentHP[0][0] = dungeon[0][0];
        
        for(int i = 1;i<rows;i++)
        {
            currentHP[i][0] = currentHP[i-1][0]+dungeon[i][0];
            maxBloodLost[i][0] =  Math.min(maxBloodLost[i-1][0],currentHP[i][0]);
            System.out.println("i = "+i+" j = 0 currentHP = "+currentHP[i][0]+ " maxBloodLost = "+maxBloodLost[i][0]);
        } 
        for(int j = 1;j<columns;j++)
        {
            currentHP[0][j] = currentHP[0][j-1]+dungeon[0][j];
            maxBloodLost[0][j] =  Math.min(maxBloodLost[0][j-1],currentHP[0][j]);
            System.out.println("i = 0 j = "+j+ " currentHP = "+currentHP[0][j]+ " maxBloodLost = "+maxBloodLost[0][j]);
        }
        
        for(int i = 1;i<rows;i++)
        {
            for(int j = 1;j<columns;j++)
            {
                final int up =  Math.min(maxBloodLost[i-1][j],currentHP[i-1][j]+dungeon[i][j]);
                final int left = Math.min(maxBloodLost[i][j-1],currentHP[i][j-1]+dungeon[i][j]);
                maxBloodLost[i][j] = Math.max(up,left);
                currentHP[i][j] = dungeon[i][j]+(up>=left?currentHP[i-1][j]:currentHP[i][j-1]);
                System.out.println("i = "+i+" j = "+j+ " currentHP = "+currentHP[i][j]+ " maxBloodLost = "+maxBloodLost[i][j]);
            }
        }
        
        return -Math.min(0,maxBloodLost[rows-1][columns-1])+1;
    }
}