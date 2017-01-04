// Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
//
//
//
//  Example 1:
// Input:  k = 3,  n = 7
// Output: 
//
// [[1,2,4]]
//
//
//  Example 2:
// Input:  k = 3,  n = 9
// Output: 
//
// [[1,2,6], [1,3,5], [2,3,4]]
//
//
//
// Credits:Special thanks to @mithmatt for adding this problem and creating all test cases.


public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        helper(k, n, 1, new ArrayList<>());
        return res;
    }
    private void helper(int k, int n, int index, ArrayList<Integer> cur) {
        if (cur.size() > k) {
            return;
        }
        if (cur.size() == k && n == 0) {
            List<Integer> list = new ArrayList<>(cur);
            res.add(list);
            return;
        }
        for (int i = index; i <= 9; i++) {
            cur.add(i);
            helper(k, n - i, i + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
