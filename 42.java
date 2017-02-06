/**
42. Trapping Rain Water
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
*/
public class Solution {
    public int trap(int[] height) {
        if(height==null||height.length==0)
        {
            return 0;
        }
        final int[] after = new int[height.length];
        int max = 0;
        for(int i =0;i<height.length;i++)
        {
            max = Math.max(max,height[i]);
            after[i] = max;
        }
        int maxDecre = 0;
        for(int i =height.length-1;i>=0&&height[i]<max;i--)
        {
            maxDecre = Math.max(maxDecre,height[i]);
            after[i] = maxDecre;
        }
        int trap = 0;
        for(int i =0;i<height.length;i++)
        {
           trap+= after[i]-height[i];
        }
        return trap;
    }
}
//O(1) space
public class Solution {
    public int trap(int[] A){
        int trap=0;
        int leftmax=0;
        int rightmax=0;
        
        int a=0;
        int b=A.length-1;
        while(a<=b){
            leftmax=Math.max(leftmax,A[a]);
            rightmax=Math.max(rightmax,A[b]);
            if(leftmax<rightmax){
                trap+=(leftmax-A[a]);       // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
                a++;
            }
            else{
                trap+=(rightmax-A[b]);
                b--;
            }
        }
        return trap;
    }
}
