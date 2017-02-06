/**
172. Factorial Trailing Zeroes
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
*/
public class Solution {
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
public class Solution {
    public int trailingZeroes(int n) {
        int count5 = 0;
        for(int i =5;i<=n;i+=5)
        {
            int number = i;
            while(number!=0&&number%5==0)
            {
                number/=5;
                count5++;
            }
        }
        return count5;
    }
}
