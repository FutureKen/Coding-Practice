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