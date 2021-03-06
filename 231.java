/**
231. Power of Two
Given an integer, write a function to determine if it is a power of two.
*/
public class Solution {
    public boolean isPowerOfTwo(int n) {
        while(n!=0&&n%2==0)
        {
            n/=2;
        }
        return n == 1;
    }
}

//Best solution
//Power of 2 means only one bit of n is '1'
public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n>0 && (n&(n-1))==0;
    }
}