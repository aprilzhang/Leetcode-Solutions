/**
69. Sqrt(x)
Implement int sqrt(int x).

Compute and return the square root of x.
*/
public class Solution {
    public int mySqrt(int x) {
        if(x==0)
        {
            return 0;
        }
        else if(x<4)
        {
            return 1;
        }
        
        int min = 1;
        int max = x/2;
        while(true)
        {
            final int mid = (min+max)/2;
            if(mid<=x/mid)//To avoid integer overflow
            {
                if (mid + 1 > x/(mid + 1))//To avoid integer overflow
                {
                    return mid;
                }
                min = mid+1;
            }
            else
            {
                max = mid-1;
            }
        }
    }
}

//Math solution
//Newton method
public class Solution {
    public int mySqrt(int x) {
        long r = x;
        while (r*r > x)
            r = (r + x/r) / 2;
        return (int) r;
    }
}