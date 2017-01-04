// Follow up for "Unique Paths":
//
// Now consider if some obstacles are added to the grids. How many unique paths would there be?
//
// An obstacle and empty space is marked as 1 and 0 respectively in the grid.
//
// For example,
// There is one obstacle in the middle of a 3x3 grid as illustrated below.
//
// [
//   [0,0,0],
//   [0,1,0],
//   [0,0,0]
// ]
//
// The total number of unique paths is 2.
//
// Note: m and n will be at most 100.


public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (m == 0 || n == 0 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        int[][] res = new int[m][n];
        res[0][0] = 1;
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                res[0][i] = 0;
            } else {
                res[0][i] = res[0][i - 1];
            }
            
        }
        for (int j = 1; j < m; j++) {
            if (obstacleGrid[j][0] == 1) {
                res[j][0] = 0;
            } else {
                res[j][0] = res[j - 1][0];
            }
        }
        for (int j = 1; j < m; j++) {
            for (int i = 1; i < n; i++) {
                if (obstacleGrid[j][i] == 1) {
                    res[j][i] = 0;
                } else {
                    res[j][i] = res[j - 1][i] + res[j][i - 1];
                }
            }
        }
        return res[m - 1][n - 1];

    }
}
