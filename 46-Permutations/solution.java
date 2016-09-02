public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
             return result; 
         }
        List<Integer> perm = new ArrayList<Integer>();
        permHelper(perm, result, nums);
        return result;
    }
    public void permHelper(List<Integer> perm, List<List<Integer>> result, int[] nums) {
        if (perm.size() == nums.length) {
            result.add(new ArrayList<Integer>(perm));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (perm.contains(nums[i])) {
                continue;
            }
            perm.add(nums[i]);
            permHelper(perm, result, nums);
            perm.remove(perm.size() - 1);
        }
    }
}