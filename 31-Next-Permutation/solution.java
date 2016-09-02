public class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            for (; nums[j] <= nums[i] ; j--);
            swap(nums, i, j);
        }
        i++;
        int k = nums.length - 1;
        while (i < k) {
            swap(nums, i, k);
            i++;
            k--;
        }
    }
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}