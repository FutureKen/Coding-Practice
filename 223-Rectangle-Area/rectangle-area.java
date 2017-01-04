// Find the total area covered by two rectilinear rectangles in a 2D plane.
// Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
//
//
//
//
// Assume that the total area is never beyond the maximum possible value of int.
//
//
// Credits:Special thanks to @mithmatt for adding this problem, creating the above image and all test cases.


public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    	int x, y = 0;
        if (G <= A || E >= C) {
        	x = 0;
        } else {
        	x = Math.min(C, G) - Math.max(A, E);
        }
        if (H <= B || F >= D) {
        	y = 0;
        } else {
        	y = Math.min(D, H) - Math.max(B, F);
        }
        return  (C - A) * (D - B) + (G - E) * (H - F) - x * y;
    }
}
