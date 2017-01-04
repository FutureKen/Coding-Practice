// Given a positive integer num, write a function which returns True if num is a perfect square else False.
//
//
// Note: Do not use any built-in library function such as sqrt.
//
//
// Example 1:
//
// Input: 16
// Returns: True
//
//
//
// Example 2:
//
// Input: 14
// Returns: False
//
//
//
// Credits:Special thanks to @elmirap for adding this problem and creating all test cases.


public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num <= 1) {
            return true;
        }
        long left = 1;
        long right = num;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long sq = mid * mid;
            if (sq > num) {
                right = mid - 1;
            } else if (sq < num) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
