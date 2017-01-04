// Given a collection of integers that might contain duplicates, nums, return all possible subsets.
//
// Note: The solution set must not contain duplicate subsets.
//
//
// For example,
// If nums = [1,2,2], a solution is:
//
//
//
// [
//   [2],
//   [1],
//   [1,2,2],
//   [2,2],
//   [1,2],
//   []
// ]


public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        subsetsgen(path, num, 0, result);
        return result;
    }
    void subsetsgen(ArrayList<Integer> path, int[] num, int pos, ArrayList<List<Integer>> result){
        ArrayList<Integer> subset = new ArrayList(path);
        result.add(subset);
        for (int i = pos; i < num.length; i++){
            if (i > pos && num[i] == num[i - 1]){
                continue;
            }
            path.add(num[i]);
            subsetsgen(path, num, i + 1, result);
            path.remove(path.size() - 1);
        }
    }
}
