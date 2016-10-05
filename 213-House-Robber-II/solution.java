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