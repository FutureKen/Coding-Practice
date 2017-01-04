// Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//
//
// Each number in C may only be used once in the combination.
//
// Note:
//
// All numbers (including target) will be positive integers.
// The solution set must not contain duplicate combinations.
//
//
//
//
// For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
// A solution set is: 
//
// [
//   [1, 7],
//   [1, 2, 5],
//   [2, 6],
//   [1, 1, 6]
// ]


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
