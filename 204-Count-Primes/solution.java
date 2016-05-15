public class Solution {
    public int countPrimes(int n) {
        boolean[] isprime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isprime[i] = true;
        }
        for (int i = 2; i * i < n; i++) {
            if (!isprime[i]) {
                continue;
            }
            for (int j = i * i; j < n; j += i) {
                isprime[j] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isprime[i] == true) {
                count++;
            }
        }
        return count;
    }
}