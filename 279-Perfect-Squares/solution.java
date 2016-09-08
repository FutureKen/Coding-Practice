public class Solution {
    public int numSquares(int n) {
        int[] least = new int[n + 1];
        Arrays.fill(least, n);
        for (int i = 1; i * i <= n; i++) {
            least[i * i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; i + j * j <= n; j++) {
                least[i + j * j] = Math.min(least[i + j * j], least[i] + 1);
            }
        }
        return least[n];
    }
}