/**
335. Self Crossing
You are given an array x of n positive numbers. You start at point (0,0) and moves x[0] metres to the north, then x[1] metres to the west, x[2] metres to the south, x[3] metres to the east and so on. In other words, after each move your direction changes counter-clockwise.

Write a one-pass algorithm with O(1) extra space to determine, if your path crosses itself, or not.

Example 1:
Given x = 
[2, 1, 1, 2]
,
+---+
¦   ¦
+---+-->
    ¦

Return true (self crossing)
Example 2:
Given x = 
[1, 2, 3, 4]
,
+------+
¦      ¦
¦
¦
+------------>

Return false (not self crossing)
Example 3:
Given x = 
[1, 1, 1, 1]
,
+---+
¦   ¦
+---+>

Return true (self crossing)
*/
//My try wrong answer
public class Solution {
    public boolean isSelfCrossing(int[] x) {
        int horizontalMin = 0;
        int horizontalMax = 0;
        int verticalMin = 0;
        int verticalMax = 0;
        
        int currentX = 0;
        int currentY = 0;
        for(int i =0;i<x.length;i++)
        {
            switch(i%4)
            {
                case 0:
                    currentY +=x[i];
                    if(i>=3&&currentX<=horizontalMax&&currentY>=verticalMax)
                    {
                        return true;
                    }
                    horizontalMax = Math.max(currentX,horizontalMax);
                    break;
                case 1:
                    currentX -=x[i];
                    if(i>=3&&currentY<=verticalMax&&currentX<=horizontalMin)
                    {
                        return true;
                    }
                    verticalMax = Math.max(currentY,verticalMax);
                    break;
                case 2:
                    currentY -=x[i];
                    if(i>=3&&currentX>=horizontalMin&&currentY<=verticalMin)
                    {
                        return true;
                    }
                    horizontalMin = Math.min(currentX,horizontalMin);
                    break;
                case 3:
                    currentX +=x[i];
                    if(i>=3&&currentY>=verticalMin&&currentX>=horizontalMax)
                    {
                        return true;
                    }
                    verticalMin = Math.min(currentY,verticalMin);
                    break;
            }
        }
        return false;
    }
}

//Correct answers
// Categorize the self-crossing scenarios, there are 3 of them: 
// 1. Fourth line crosses first line and works for fifth line crosses second line and so on...
// 2. Fifth line meets first line and works for the lines after
// 3. Sixth line crosses first line and works for the lines after
public class Solution {
    public boolean isSelfCrossing(int[] x) {
        if(x.length <= 3) return false;
        
        for(int i =3;i<x.length;i++)
        {
            if(x[i] >= x[i-2] && x[i-1] <= x[i-3])
            {
                return true;  //Fourth line crosses first line and onward
            }
            if(i >=4)
            {
                if(x[i-1] == x[i-3] && x[i] + x[i-4] >= x[i-2])
                {
                    return true;// Fifth line meets first line and onward
                }
            }
            if(i >=5)
            {
                if(x[i-2] - x[i-4] >= 0 && x[i] >= x[i-2] - x[i-4] 
                && x[i-1] <= x[i-3] && x[i-1] +  x[i-5]>= x[i-3] ) 
                {
                    return true;  // Sixth line crosses first line and onward
                }
            }
        }
        return false;
    }
}

//Faster solution
public class Solution {
    public boolean isSelfCrossing(int[] x) {
        if (x.length <= 3) {
            return false;
        }
        int i = 2;
        // keep spiraling outward
        while (i < x.length && x[i] > x[i - 2]) {
            i++;
        }
        if (i >= x.length) {
            return false;
        }
        // transition from spiraling outward to spiraling inward
        if ((i >= 4 && x[i] >= x[i - 2] - x[i - 4]) ||
                (i == 3 && x[i] == x[i - 2])) {
            x[i - 1] -= x[i - 3];
        }
        i++;
        // keep spiraling inward
        while (i < x.length) {
            if (x[i] >= x[i - 2]) {
                return true;
            }
            i++;
        }
        return false;
    }
}