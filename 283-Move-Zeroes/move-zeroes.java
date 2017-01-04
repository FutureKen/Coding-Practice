// Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//
//
//
// For example, given nums  = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
//
//
//
// Note:
//
// You must do this in-place without making a copy of the array.
// Minimize the total number of operations.
//
//
//
// Credits:Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.


public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return;
        }
        int index = 0;
        for (int element : nums) {
        	if (element != 0) {
        		nums[index] = element;
        		index++;
        	}
        }
        while (index < nums.length) {
        	nums[index] = 0;
        	index++;
        }
    }
}