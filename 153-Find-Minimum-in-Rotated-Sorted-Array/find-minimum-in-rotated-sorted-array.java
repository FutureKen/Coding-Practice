// Suppose a sorted array is rotated at some pivot unknown to you beforehand.
//
// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
// Find the minimum element.
//
// You may assume no duplicate exists in the array.


public class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int target = nums[end];
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] <= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] <= target) {
            return nums[start];
        } else {
            return nums[end];
        }
    }
}
