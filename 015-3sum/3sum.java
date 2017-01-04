// Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
// Note: The solution set must not contain duplicate triplets.
//
//
// For example, given array S = [-1, 0, 1, 2, -1, -4],
//
// A solution set is:
// [
//   [-1, 0, 1],
//   [-1, -1, 2]
// ]


public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
        	if (i != 0 && nums[i] == nums[i - 1]) {
				continue; // to skip serial duplicates;
			}
        	int left = i + 1;
        	int right = nums.length - 1;
        	while (left < right) {
        		if (nums[left] + nums[right] == -nums[i]) {
        			result.add(Arrays.asList(nums[i], nums[left], nums[right]));
        			left++;
        			right--;
        			while (left < right && nums[left] == nums[left - 1]) { // to skip duplicates
						left++;
					}
					while (left < right && nums[right] == nums[right + 1]) { // to skip duplicates
						right--;
					} 			
        		} else if (nums[left] + nums[right] > -nums[i]) {
        			right--;
        		} else {
        			left++;
        		}
        	}
        }
        return result;
    }
}
