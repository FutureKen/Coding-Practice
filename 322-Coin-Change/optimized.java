public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] res = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            res[i] = amount + 1;
        } 
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                res[i] = Math.min(res[i], res[i - coin] + 1);
            }
        }
        return res[amount] > amount ? -1 : res[amount];
    }
}