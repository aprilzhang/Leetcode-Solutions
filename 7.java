/**
7. Reverse Integer
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.

Have you thought about this?
Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

Note:
The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
*/
public class Solution {
    public int reverse(int x) {
        final String xString = Integer.toString(x);
        final boolean isNegative = xString.charAt(0)=='-';
        long result = 0;
        for(int i = xString.length()-1;i>=(isNegative?1:0);i--)
        {
            result = 10*result+(xString.charAt(i)-'0');
        }
        if(isNegative)
        {
            result = -result;
        }
        if(Integer.MIN_VALUE<=result&&Integer.MAX_VALUE>=result)
        {
            return (int)result;
        }
        return 0;
    }
}

//slightly faster
public class Solution {
    public int reverse(int x) {
        long result = 0;
        while( x!=0)
        {
            result = 10*result+x%10;
            x /=10;
            if(Integer.MIN_VALUE>result||Integer.MAX_VALUE<result)
            {
                return 0;
            }
        }
        return (int)result;
    }
}

//best solution
public class Solution {
    public int reverse(int x)
    {
        int result = 0;
        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            //If overflow exists, the new result will not equal previous one.
            if ((newResult - tail) / 10 != result)
            { 
                return 0; 
            }
            result = newResult;
            x = x / 10;
        }
        return result;
    }
}