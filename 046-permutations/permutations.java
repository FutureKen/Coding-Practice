// Given a collection of distinct numbers, return all possible permutations.
//
//
//
// For example,
// [1,2,3] have the following permutations:
//
// [
//   [1,2,3],
//   [1,3,2],
//   [2,1,3],
//   [2,3,1],
//   [3,1,2],
//   [3,2,1]
// ]


public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        cur.add(nums[0]);
        result.add(cur);
        for (int i = 1; i < nums.length; i++) {
            int cursize = result.size();
            for (int j = 0; j < cursize; j++) {
                for (int k = 0; k < result.get(j).size(); k++) {
                    List<Integer> newlist = new ArrayList<Integer>(result.get(j));
                    newlist.add(k, nums[i]);
                    result.add(newlist);
                }
                result.get(j).add(nums[i]);
            }
        }
        return result;
    }
}
