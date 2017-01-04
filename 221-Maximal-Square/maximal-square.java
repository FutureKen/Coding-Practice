// Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
//
//
// For example, given the following matrix:
//
// 1 0 1 0 0
// 1 0 1 1 1
// 1 1 1 1 1
// 1 0 0 1 0
//
// Return 4.
//
//
// Credits:Special thanks to @Freezen for adding this problem and creating all test cases.


public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row + 1][col + 1];
        int result = 0;//result store the longest length of square edge;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j- 1]), dp[i - 1][j - 1]) + 1; //Compare top-left, top & left, if those three are the same, we can get a longer edge.
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result * result;
    }
}
