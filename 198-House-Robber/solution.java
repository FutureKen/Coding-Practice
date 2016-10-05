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