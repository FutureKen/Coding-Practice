// Given an integer n, return the number of trailing zeroes in n!.
//
// Note: Your solution should be in logarithmic time complexity.
//
// Credits:Special thanks to @ts for adding this problem and creating all test cases.


public class Solution {
    public int trailingZeroes(int n) {
        int sum = 0;
        while (n / 5 != 0){
        	sum += n / 5;
        	n = n / 5;
        }
        return sum;
    }
}
