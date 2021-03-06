// You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
//
//
//
// Example 1:
// coins = [1, 2, 5], amount = 11
// return 3 (11 = 5 + 5 + 1)
//
//
//
// Example 2:
// coins = [2], amount = 3
// return -1.
//
//
//
// Note:
// You may assume that you have an infinite number of each kind of coin.
//
//
// Credits:Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.


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
