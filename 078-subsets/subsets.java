// Given a set of distinct integers, nums, return all possible subsets.
//
// Note: The solution set must not contain duplicate subsets.
//
//
// For example,
// If nums = [1,2,3], a solution is:
//
//
//
// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]


public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        subsetsgen(path, S, 0, result);
        return result;
    }
    void subsetsgen(ArrayList<Integer> path, int[] S, int pos, ArrayList<List<Integer>> result){
        ArrayList<Integer> subset = new ArrayList(path);
        result.add(subset);
        for (int i = pos; i < S.length; i++){
            path.add(S[i]);
            subsetsgen(path, S, i + 1, result);
            path.remove(path.size() - 1);
        }
    }
}
