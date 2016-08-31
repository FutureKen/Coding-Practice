public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        boolean neg = (dividend < 0) ^ (divisor < 0);
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        long result = 0;
        
        while (a >= b) {
            int shift = 0;
            while (a > (b << shift + 1)) {
                shift++;
            }
            a -= (b << shift);
            result += (1 << shift);
        }
        if (neg) {
            result = ~(result - 1);
            result = Math.max(Integer.MIN_VALUE, result);
        } else {
            result = Math.min(Integer.MAX_VALUE, result);
        }
        return (int)result;
    }
}