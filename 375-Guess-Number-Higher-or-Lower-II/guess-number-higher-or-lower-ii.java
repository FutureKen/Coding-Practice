// We are playing the Guess Game. The game is as follows: 
//
// I pick a number from 1 to n. You have to guess which number I picked.
//
// Every time you guess wrong, I'll tell you whether the number I picked is higher or lower. 
//
// However, when you guess a particular number x,  and you guess wrong, you pay $x. You win the game when you guess the number I picked.
//
//
// Example:
//
// n = 10, I pick 8.
//
// First round:  You guess 5, I tell you that it's higher. You pay $5.
// Second round: You guess 7, I tell you that it's higher. You pay $7.
// Third round:  You guess 9, I tell you that it's lower. You pay $9.
//
// Game over. 8 is the number I picked.
//
// You end up paying $5 + $7 + $9 = $21.
//
//
//
// Given a particular n &ge; 1, find out how much money you need to have to guarantee a win.
//
//
//    The best strategy to play the game is to minimize the maximum loss you could possibly face. Another strategy is to minimize the expected loss. Here, we are interested in the first scenario.
//    Take a small example (n = 3). What do you end up paying in the worst case?
//   Check out this article if you're still stuck.
//  The purely recursive implementation of minimax would be worthless for even a small n. You MUST use dynamic programming. 
//  As a follow-up, how would you modify your code to solve the problem of minimizing the expected loss, instead of the worst-case loss? 
//
//
// Credits:Special thanks to @agave and @StefanPochmann for adding this problem and creating all test cases.


public class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return helper(dp, 1, n);
    }
    private int helper(int[][] t, int s, int e) {
        if (s >= e) {
            return 0;
        }
        if (t[s][e] != 0) {
            return t[s][e];
        }
        int res = Integer.MAX_VALUE;
        for (int i = s; i <= e; i++) {
            int tmp = i + Math.max(helper(t, s, i - 1), helper(t, i + 1, e));
            res = Math.min(res, tmp);
        }
        t[s][e] = res;
        return res;
    }
}


/* For each number x in range[i~j]
we do: result_when_pick_x = x + max{DP([i ~ x-1]), DP([x+1 ~ j])}
--> // the max means whenever you choose a number, the feedback is always bad and therefore leads you to a worse branch.
then we get DP([i ~ j]) = min{xi, ... ,xj}
--> // this min makes sure that you are minimizing your cost. */
