// Implement int sqrt(int x).
//
// Compute and return the square root of x.


public class Solution {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int left = 1;
        int right = x;
        
        while (left < right) {
            int mid = right - (right - left) / 2;
            if (mid <= x / mid) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
