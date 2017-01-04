// Note: This is an extension of House Robber.
//
// After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street. 
//
// Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
//
// Credits:Special thanks to @Freezen for adding this problem and creating all test cases.


public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        //Can't rob 1st and last at same time, so we find the max if we rob the range of exluding either;
        return Math.max(robRange(nums, 0, nums.length - 2), robRange(nums, 1, nums.length - 1));
    }
    public int robRange(int[] nums, int l, int r) {
        //Use two int to record the max value if we rob prev or not;
        int prevY = 0;
        int prevN = 0;
        for (int i = l; i <= r; i++) {
            int temp = prevY;
            //Rob current house or not;
            prevY = prevN + nums[i];  //We rob cur one, update prevY max;
            prevN = Math.max(prevN, temp); //We don't rob cur one, update max;
        }
        return Math.max(prevY, prevN);
    }
}
