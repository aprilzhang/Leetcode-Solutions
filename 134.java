/**
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
*/
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas==null||cost==null||gas.length==0||cost.length==0)
        {
            return -1;
        }
        int start =0;
        int tank = 0;
        int total = 0;
        for(int i =0;i<gas.length;i++)
        {
            tank += gas[i]-cost[i];
            total += gas[i]-cost[i];
            //if car fails at 'start', record the next station
            if(tank<0)
            {  
                //If car starts at A and can not reach B. Any station between A and B
                //can not reach B.(B is the first station that A can not reach.)
                start = i+1;
                tank = 0;
            }
        }
        //if the total number of gas is bigger than the total number of cost. There must be a solution.
        return total>=0?start:-1;
    }
}