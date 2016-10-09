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