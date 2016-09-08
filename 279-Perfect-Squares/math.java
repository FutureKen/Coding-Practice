public class Solution {
    public int numSquares(int n) {
        while (n % 4 == 0) {
            n /= 4;
        }
        if (n % 8 == 7) {
            return 4;
        }
        for (int i = 0; i * i <= n; i++) {
            int j = (int)Math.sqrt(n * 1.0 - i * i);
            if (i * i + j * j == n) {
                int rst = 0;
                if (i > 0) {
                    rst++;
                }
                if (j > 0) {
                    rst++;
                }
                return rst;
            }
        }
        return 3;
    }
}