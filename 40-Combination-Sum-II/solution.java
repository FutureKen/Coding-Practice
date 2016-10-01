public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, target, new ArrayList<Integer>(), 0);
        return result;
    }
    private void helper(int[] can, int tar, List<Integer> current, int start) {
        if (tar > 0) {
            for (int i = start; i < can.length && tar >= can[i]; i++) {
                if (i > start && can[i] == can[i - 1]) {
                    continue;
                }
                current.add(can[i]);
                helper(can, tar - can[i], current, i + 1);
                current.remove(current.size() - 1);
            }
        } else if (tar == 0) {
            result.add(new ArrayList<Integer>(current));
        }
    }
}