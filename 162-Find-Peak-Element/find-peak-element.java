// A peak element is an element that is greater than its neighbors.
//
// Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
//
// The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
//
// You may imagine that num[-1] = num[n] = -∞.
//
// For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
//
// click to show spoilers.
//
// Note:
// Your solution should be in logarithmic complexity.
//
//
// Credits:Special thanks to @ts for adding this problem and creating all test cases.


public class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid1 = (start + end) / 2;
            int mid2 = mid1 + 1;
            if (nums[mid1] < nums[mid2]) {
                start = mid2;
            } else {
                end = mid1;
            }
        }
        return start;
    }
}
