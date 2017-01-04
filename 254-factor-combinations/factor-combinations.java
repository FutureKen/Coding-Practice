// Numbers can be regarded as product of its factors. For example,  
//
// 8 = 2 x 2 x 2;
//   = 2 x 4.
//
// Write a function that takes an integer n and return all possible combinations of its factors. 
//
//
// Note: 
//
// You may assume that n is always positive. 
// Factors should be greater than 1 and less than n.
//
//
//
// Examples: 
//  input: 1
//  output: 
//
// []
//
// input: 37
//  output: 
//
// []
//
//  input: 12
//  output:
//
// [
//   [2, 6],
//   [2, 2, 3],
//   [3, 4]
// ]
//
//  input: 32
//  output:
//
// [
//   [2, 16],
//   [2, 2, 8],
//   [2, 2, 2, 4],
//   [2, 2, 2, 2, 2],
//   [2, 4, 4],
//   [4, 8]
// ]


public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<Integer>(), 2, n);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> cur, int start, int end) {
        if (!cur.isEmpty()) {
            cur.add(end);
            res.add(new ArrayList<Integer>(cur));
            cur.remove(cur.size() - 1);
        }

        for (int i = start; i <= (int)Math.sqrt(end); i++) {
            if (end % i == 0) {
                cur.add(i);
                int newend = end / i;
                helper(res, cur, i, newend);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
