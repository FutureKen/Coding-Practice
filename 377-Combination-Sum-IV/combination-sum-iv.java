// Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.
//
// Example:
//
// nums = [1, 2, 3]
// target = 4
//
// The possible combination ways are:
// (1, 1, 1, 1)
// (1, 1, 2)
// (1, 2, 1)
// (1, 3)
// (2, 1, 1)
// (2, 2)
// (3, 1)
//
// Note that different sequences are counted as different combinations.
//
// Therefore the output is 7.
//
//
//
// Follow up:
// What if negative numbers are allowed in the given array?
// How does it change the problem?
// What limitation we need to add to the question to allow negative numbers? 
//
// Credits:Special thanks to @pbrother for adding this problem and creating all test cases.


public class Solution {
    int[] dp;
    public int combinationSum4(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(nums, target);
    }
    private int helper(int[] nums, int target) {
        if (dp[target] != -1) {
            return dp[target];
        }
        int res = 0;
        for (int num : nums) {
            if (target >= num) {
                res += helper(nums, target - num);
            }
        }
        dp[target] = res;
        return dp[target];
    }
}
