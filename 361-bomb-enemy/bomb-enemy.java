// Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb. The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
//  Note that you can only put the bomb at an empty cell. 
//
// Example:
//
// For the given grid
//
// 0 E 0 0
// E 0 W E
// 0 E 0 0
//
// return 3. (Placing a bomb at (1,1) kills 3 enemies)
//
//
//
// Credits:Special thanks to @memoryless for adding this problem and creating all test cases.


public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        int row = 0; //Kills on a row;
        int[] col = new int[n]; //Kills on a col;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'W') {
                    continue;
                }

                if (j == 0 || grid[i][j - 1] == 'W') {
                    row = 0; //If this is first spot each row or left spot has row, recalculate this row;
                    for (int k = j; k < n && grid[i][k] != 'W'; k++) {
                        if (grid[i][k] == 'E') {
                            row++;
                        }
                    }
                }
                if (i == 0 || grid[i - 1][j] == 'W') {
                    col[j] = 0; //If the top spot is W, recalculate this col;
                    for (int k = i; k < m && grid[k][j] != 'W'; k++) {
                        if (grid[k][j] == 'E') {
                            col[j]++;
                        }
                    }
                }
                if (grid[i][j] == '0') {
                    max = Math.max(max, row + col[j]); //Only calcualte max when it's '0';
                }
            }
        }
        return max;
    }
}
