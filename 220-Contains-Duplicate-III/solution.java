public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || k < 1 || t < 0) {
            return false;
        }
        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < nums.length; i++) {
            SortedSet<Long> subset = set.subSet((long)nums[i]-t, (long)nums[i]+t+1);
            if (!subset.isEmpty()) {
                return true;
            }
            if (i >= k) {
                set.remove((long)nums[i - k]);
            }
            set.add((long)nums[i]);
        }
        return false;
    }
}