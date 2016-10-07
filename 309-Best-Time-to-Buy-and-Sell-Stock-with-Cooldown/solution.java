public class Solution {
    public int maxProfit(int[] prices) {
        int prev_sell = 0, sell = 0, buy = Integer.MIN_VALUE, prev_buy;
        for (int p : prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - p, prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + p, prev_sell);
        }
        return sell;
    }
}