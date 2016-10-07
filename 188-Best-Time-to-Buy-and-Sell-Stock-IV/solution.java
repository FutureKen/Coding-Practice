public class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        //if k is bigger than half size of prices, it turns to be the buy stock II question, we use greedy algorithm to solve it.
        if (k >= n / 2) {
            return greedy(prices);
        }
        //Let profit[i][j] represent maximum profit using at most i transactions up to day j (including day j).
        int[][] profit = new int[k + 1][n + 1];
        //curMax means the maximum profit of just making at most i-1 transactions, using at most first j-1 prices, and buying the stock at price[j], this is used for the next loop.
        int curMax;
        for (int i = 1; i <= k; i++) {
            curMax = -prices[0];
            for (int j = 1; j < n; j++) {
                profit[i][j] = Math.max(profit[i][j - 1], prices[j] + curMax); //1. We don't buy in at day j. 2. We buy in at day j;
                curMax = Math.max(curMax, profit[i - 1][j - 1] - prices[j]);
            }
        }
        return profit[k][n - 1];
    }

    private int greedy(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                max += prices[i + 1] - prices[i];
            }
        }
        return max;
    }
}