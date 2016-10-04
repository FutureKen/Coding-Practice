public class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] res = new int[m][n];
        for (int i = 0; i < n; i++) {
            res[0][i] = 1;
        }
        for (int j = 1; j < m; j++) {
            res[j][0] = 1;
        }
        for (int j = 1; j < m; j++) {
            for (int i = 1; i < n; i++) {
                res[j][i] = res[j - 1][i] + res[j][i - 1];
            }
        }
        return res[m - 1][n - 1];
    }
}