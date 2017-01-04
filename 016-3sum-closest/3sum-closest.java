// Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
//
//
//     For example, given array S = {-1 2 1 -4}, and target = 1.
//
//     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).


public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
        	if (i != 0 && nums[i] == nums[i - 1]) {
				continue; // to skip serial duplicates;
			}
        	int left = i + 1;
        	int right = nums.length - 1;
        	while (left < right) {
        		int sum = nums[left] + nums[right] + nums[i];
        		if (sum == target) {
        			return target;		
        		} else if (sum > target) {
        			if (Math.abs(sum - target) < diff) {
        				diff = Math.abs(sum - target);
        				result = sum;
        			}
        			right--;
        			while (left < right && nums[right] == nums[right + 1]) { // to skip duplicates
						right--;
					} 	
        		} else {
        			if (Math.abs(sum - target) < diff) {
        				diff = Math.abs(sum - target);
        				result = sum;
        			}
        			left++;
        			while (left < right && nums[left] == nums[left - 1]) { // to skip duplicates
						left++;
					}
        		}
        	}
        }
        return result;
    }
}
