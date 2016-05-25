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