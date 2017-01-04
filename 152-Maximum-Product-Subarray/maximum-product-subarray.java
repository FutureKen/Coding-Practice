// Find the contiguous subarray within an array (containing at least one number) which has the largest product.
//
//
//
// For example, given the array [2,3,-2,4],
// the contiguous subarray [2,3] has the largest product = 6.


public class Solution {
    public int maxProduct(int[] nums) {
        int maxPrev = nums[0]; //To record largest positive num;
        int minPrev = nums[0]; //To record smallest negative num;
        int maxofall = nums[0];
        int maxCur, minCur;
        for (int i = 1; i < nums.length; i++) {
            maxCur = Math.max(Math.max(maxPrev * nums[i], minPrev * nums[i]), nums[i]);
            minCur = Math.min(Math.min(maxPrev * nums[i], minPrev * nums[i]), nums[i]);
            maxofall = Math.max(maxofall, maxCur);
            maxPrev = maxCur;
            minPrev = minCur;
        }
        return maxofall;
    }
}
