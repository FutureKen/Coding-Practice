public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        HashSet<Integer> exist = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (exist.contains(nums[i])) {
                return true;
            } else {
                exist.add(nums[i]);
            }
        }
        return false;
    }
}