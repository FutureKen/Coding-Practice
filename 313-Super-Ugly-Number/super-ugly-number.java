// Write a program to find the nth super ugly number.
//
//
//
//     Super ugly numbers are positive numbers whose all prime factors are in the given prime list
//     primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32]
//  is the sequence of the first 12 super ugly numbers given primes
//     = [2, 7, 13, 19] of size 4.
//
//
//
//     Note:
//     (1) 1 is a super ugly number for any given primes.
//     (2) The given numbers in primes are in ascending order.
//     (3) 0 < k &le; 100, 0 < n &le; 106, 0 < primes[i] < 1000.
//
//
// Credits:Special thanks to @dietpepsi for adding this problem and creating all test cases.


public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] index = new int[primes.length];
        int[] factor = new int[primes.length];
        System.arraycopy(primes, 0, factor, 0, primes.length);
        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            ugly[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                if (ugly[i - 1] == factor[j]) {
                    factor[j] = primes[j] * ugly[++index[j]];
                }
                ugly[i] = Math.min(ugly[i], factor[j]);
            }
        }
        return ugly[n - 1];
    }
}
