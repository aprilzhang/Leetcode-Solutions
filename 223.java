/**
223. Rectangle Area
Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

Rectangle Area
Assume that the total area is never beyond the maximum possible value of int.
*/
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        final long overlapHeight = ((B>H&&D>F)||(D<F&&B<H))?0:Math.min(D,H)-Math.max(B,F);
        final long overlapLength = ((A>G&&C>E)||(A<G&&C<E))?0:Math.min(C,G)-Math.max(A,E);
        final long area1 = (C-A)*(D-B);
        final long area2 = (G-E)*(H-F);
        final long overlapArea = overlapHeight*overlapLength;
        return (int)(area1+area2-overlapArea);
    }
}

//Slightly cleaner solution
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        final int left = Math.max(A,E);
        final int right = Math.max(Math.min(C,G), left);
        final int overlapHeight = right-left;
        
        final int bottom = Math.max(B,F);
        final int top = Math.max(Math.min(D,H), bottom);
        final int overlapLength = top-bottom;
        
        final int area1 = (C-A)*(D-B);
        final int area2 = (G-E)*(H-F);
        final int overlapArea = overlapHeight*overlapLength;
        
        return area1+area2-overlapArea;
    }
}