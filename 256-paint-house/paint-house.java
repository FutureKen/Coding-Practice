// There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
//
//
// The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.
//
//
// Note:
// All costs are positive integers.


public class Solution {
    public int minCost(int[][] costs) {
        if (costs.length == 0 || costs == null) {
            return 0;
        }
        //DP process, store the current minCost by picking each color.
        int n = costs.length;
        int[][] min = new int[n][3];
        min[0][0] = costs[0][0];
        min[0][1] = costs[0][1];
        min[0][2] = costs[0][2];
        for (int i = 1; i < n; i++) {
            min[i][0] = Math.min(min[i - 1][1], min[i - 1][2]) + costs[i][0];
            min[i][1] = Math.min(min[i - 1][0], min[i - 1][2]) + costs[i][1];
            min[i][2] = Math.min(min[i - 1][0], min[i - 1][1]) + costs[i][2];
        }
        return Math.min(min[n - 1][0], Math.min(min[n - 1][1], min[n - 1][2]));
    }
}
