// You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
//
// Each 0 marks an empty land which you can pass by freely.
// Each 1 marks a building which you cannot pass through.
// Each 2 marks an obstacle which you cannot pass through.
//
//
// For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):
//
// 1 - 0 - 2 - 0 - 1
// |   |   |   |   |
// 0 - 0 - 0 - 0 - 0
// |   |   |   |   |
// 0 - 0 - 1 - 0 - 0
//
// The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.
//
// Note:
// There will be at least one building. If it is not possible to build such house according to the above rules, return -1.


public class Solution {
    static final int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; 
    int min = Integer.MAX_VALUE;
    public int shortestDistance(int[][] grid) {
        int[][] dist = new int[grid.length][grid[0].length]; //Store the shorest dist to all blding.
        int start = 1; // Use this indicate each bfs;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    bfs(grid, dist, i, j, --start);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void bfs(int[][] grid, int[][] dist, int row, int col, int start) {
        Queue<int[]> pos = new LinkedList<>();
        pos.offer(new int[]{row, col});
        int level = 0;
        min = Integer.MAX_VALUE;
        while(!pos.isEmpty()) {
            int size = pos.size();
            level++;
            for (int k = 0; k < size; k++) {
                int[] p = pos.poll();
                for (int[] d : dir) {
                    int nRow = p[0] + d[0];
                    int nCol = p[1] + d[1];
                    if (nRow >= 0 && nCol >= 0 && nRow < grid.length && nCol < grid[0].length && grid[nRow][nCol] == start) {
                        pos.offer(new int[]{nRow, nCol});
                        dist[nRow][nCol] += level; //Update distance after each visit;
                        grid[nRow][nCol]--; //Update empty slot after each visit with start;
                        min = Math.min(min, dist[nRow][nCol]);
                    }
                }
            }     
        }
    }
}
