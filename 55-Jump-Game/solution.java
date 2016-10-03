public class Solution {
    public boolean canJump(int[] nums) {
        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxDistance < i) {
                return false;
            }
            maxDistance = (i + nums[i]) > maxDistance ? i + nums[i] : maxDistance;
        }
        return true;
    }
}