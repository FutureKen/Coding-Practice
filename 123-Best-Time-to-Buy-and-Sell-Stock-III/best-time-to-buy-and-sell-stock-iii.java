// Say you have an array for which the ith element is the price of a given stock on day i.
//
// Design an algorithm to find the maximum profit. You may complete at most two transactions.
//
// Note:
// You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).


public class Solution {
    public int maxProfit(int[] prices) {
        int max1 = 0; //Max profit of single transaction;
        int max2 = 0; //Max profit of both transactions in total;
        int low1 = Integer.MAX_VALUE;
        int low2 = Integer.MAX_VALUE;
        for (int p : prices) {
            max2 = Math.max(max2, p - low2);
            low2 = Math.min(low2, p - max1);
            max1 = Math.max(p - low1, max1);
            low1 = Math.min(p, low1);
        }
        return max2;
    }
}
