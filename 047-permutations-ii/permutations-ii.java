// Given a collection of numbers that might contain duplicates, return all possible unique permutations.
//
//
//
// For example,
// [1,1,2] have the following unique permutations:
//
// [
//   [1,1,2],
//   [1,2,1],
//   [2,1,1]
// ]


public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        result.add(convertArrayToList(nums));
        while (nextPermutation(nums)) {
            result.add(convertArrayToList(nums));
        }
        return result;
    }

    public boolean nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            for (; nums[j] <= nums[i] ; j--);
            swap(nums, i, j);
        } else {
            return false;
        }
        i++;
        int k = nums.length - 1;
        while (i < k) {
            swap(nums, i, k);
            i++;
            k--;
        }
        return true;
    }
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    private ArrayList<Integer> convertArrayToList(int[] num) {
    ArrayList<Integer> item = new ArrayList<Integer>();
    for (int h = 0; h < num.length; h++) {
        item.add(num[h]);
    }
    return item;
    }
}
