/**
70. Climbing Stairs
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.
*/
//My slow recursive solution
public class Solution {
    public int climbStairs(int n) {
        if(n<=2)
        {
            return n;
        }
        return climbStairs(n-2)+climbStairs(n-1);
    }
}
//correct solution fibonacci.
public class Solution {
    public int climbStairs(int n) {
        if(n<=2)
        {
            return n;
        }
        int one_step_before = 2;
        int two_steps_before = 1;
        int all_ways = 0;
        
        for(int i=2; i<n; i++){
        	all_ways = one_step_before + two_steps_before;
        	two_steps_before = one_step_before;
            one_step_before = all_ways;
        }
        return all_ways;
    }
}