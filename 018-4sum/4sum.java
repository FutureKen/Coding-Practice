// Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
//
// Note: The solution set must not contain duplicate quadruplets.
//
//
//
// For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
//
// A solution set is:
// [
//   [-1,  0, 0, 1],
//   [-2, -1, 1, 2],
//   [-2,  0, 0, 2]
// ]


public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (nums[i] << 2 > target) {
                return result; //If smallest number *4 larger than target, no more solutions;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; //Skip duplicates
            }
            for (int j = nums.length - 1; j > i + 2; j--) {
                if (nums[j] << 2 < target) {
                    break; //If largest number*4 smaller than target, no more solutions.
                }
                if (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                    continue; // Skip duplicates
                }
                int left = i + 1;
                int right = j - 1;
                int remain = target - nums[i] - nums[j];
                while (left < right) {
                    if (nums[left] + nums[right] == remain) {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right], nums[j]));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }

                    } else if (nums[left] + nums[right] > remain) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
