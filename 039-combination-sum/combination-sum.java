// Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T. 
//
//
// The same repeated number may be chosen from C unlimited number of times.
//
//
// Note:
//
// All numbers (including target) will be positive integers.
// The solution set must not contain duplicate combinations.
//
//
//
//
// For example, given candidate set [2, 3, 6, 7] and target 7, 
// A solution set is: 
//
// [
//   [7],
//   [2, 2, 3]
// ]


public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, target, new ArrayList<Integer>(), 0);
        return result;
    }
    private void helper(int[] can, int tar, List<Integer> current, int start) {
        if (tar > 0) {
            for (int i = start; i < can.length && tar >= can[i]; i++) {
                current.add(can[i]);
                helper(can, tar - can[i], current, i);
                current.remove(current.size() - 1);
            }
        } else if (tar == 0) {
            result.add(new ArrayList<Integer>(current));
        }
    }
}
