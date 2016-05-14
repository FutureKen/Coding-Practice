public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        if (n == 0) {
            return 0;
        }
        int count = 1;
        //The result of (number AND number-1) will remove one "1" bit.
        while ((n & (n-1)) != 0) {
            n &= n-1;
            count++;
        }
        return count;
    }
}