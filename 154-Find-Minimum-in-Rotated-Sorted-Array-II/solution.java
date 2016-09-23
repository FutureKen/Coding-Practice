public class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int target = nums[end];
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < nums[end]) {
                end = mid;
            } else if (nums[mid] > nums[end]) {
                start = mid;
            } else {
                end--;
            }
        }
        if (nums[start] <= nums[end]) {
            return nums[start];
        } else {
            return nums[end];
        }
    }
}