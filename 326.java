/**
Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?
*/
//This happens because log(3) is actually slightly larger than its true value due to round off, which makes the ratio smaller.
public class Solution {
    public boolean isPowerOfThree(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
}

//convert the original number into radix-3 forma
public boolean isPowerOfThree(int n) {
    return Integer.toString(n, 3).matches("10*");
}

//simply hard code it since we know maxPowerOfThree = 1162261467
public boolean isPowerOfThree(int n) {
    return n > 0 && (1162261467 % n == 0);
}