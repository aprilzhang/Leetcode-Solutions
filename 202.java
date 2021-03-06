/**
202. Happy Number
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
*/
public class Solution {
    //Linked List Cycle detection problem
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(digitSquareSum(fast));
        } 
        while(slow != fast);
        
        return slow == 1;
    }
    private static int digitSquareSum(int n) {
        int sum = 0;
        int number = n;
        while(number!=0)
        {
            sum+=Math.pow(number%10,2);
            number/=10;
        }
        return sum;
    }
}