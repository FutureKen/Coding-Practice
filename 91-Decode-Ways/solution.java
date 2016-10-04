public class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[n] = 1; //If there is empty string, there is always 1 decode.
        dp[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1; //The last char, if non-zero, 1 decode.
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                continue;
            }
            //12xxxx -> 1,2xxxx or 12,xxxx; 32xxxx - > 3,2xxxx
            dp[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26 ? dp[i + 1] + dp[i + 2] : dp[i + 1]);
        }
        return dp[0];
    }
}