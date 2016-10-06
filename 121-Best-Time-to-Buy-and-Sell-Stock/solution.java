public class Solution {
    public int maxProfit(int[] prices) {
        int maxp = 0;
        int low = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            maxp = (prices[i] - low) > maxp ? prices[i] - low : maxp;
            low = prices[i] < low ? prices[i] : low;
        }
        return maxp;
    }
}