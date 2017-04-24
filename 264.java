/**
264. Ugly Number II
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number, and n does not exceed 1690.
*/
//TLE
public class Solution {
    public int nthUglyNumber(int n) {
        final Set<Integer> uglyNumbers = new HashSet<>();
        uglyNumbers.add(1);
        int number =1;
        while(uglyNumbers.size()<n)
        {
            number++;
            if((number%2==0&&uglyNumbers.contains(number/2))
            ||(number%3==0&&uglyNumbers.contains(number/3))
            ||(number%5==0&&uglyNumbers.contains(number/5)))
            {
                uglyNumbers.add(number);
            }
        }
        return number;
    }
}

//Best solution
/**
The idea of this solution is from this page:http://www.geeksforgeeks.org/ugly-numbers/

The ugly-number sequence is 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, �
because every number can only be divided by 2, 3, 5, one way to look at the sequence is to split the sequence to three groups as below:

(1) 1�2, 2�2, 3�2, 4�2, 5�2, �
(2) 1�3, 2�3, 3�3, 4�3, 5�3, �
(3) 1�5, 2�5, 3�5, 4�5, 5�5, �
We can find that every subsequence is the ugly-sequence itself (1, 2, 3, 4, 5, �) multiply 2, 3, 5.
Then we use similar merge method as merge sort, to get every ugly number from the three subsequence.
Every step we choose the smallest one, and move one step after,including nums with same value.
*/
//Since each previous ugly number times one of the multiplier will produce a new ugly number
public class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i=1;i<n;i++){
            int min = Math.min(Math.min(factor2,factor3),factor5);
            ugly[i] = min;
            if(factor2 == min)
                factor2 = 2*ugly[++index2];
            if(factor3 == min)
                factor3 = 3*ugly[++index3];
            if(factor5 == min)
                factor5 = 5*ugly[++index5];
        }
        return ugly[n-1];
    }
}