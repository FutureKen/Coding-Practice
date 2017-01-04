// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
//
// Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
//
// Credits:Special thanks to @ifanchu for adding this problem and creating all test cases. Also thanks to @ts for adding additional test cases.


public class Solution {
    public int rob(int[] nums) {
        //Use two int to record the max value if we rob prev or not;
        int prevY = 0;
        int prevN = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = prevY;
            //Rob current house or not;
            prevY = prevN + nums[i];  //We rob cur one, update max;
            prevN = Math.max(temp, prevN); //We don't rob cur one, update max;
        }
        return Math.max(prevY, prevN);
    }
}
