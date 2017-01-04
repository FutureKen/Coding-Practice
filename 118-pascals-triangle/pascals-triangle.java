// Given numRows, generate the first numRows of Pascal's triangle.
//
//
// For example, given numRows = 5,
// Return
//
// [
//      [1],
//     [1,1],
//    [1,2,1],
//   [1,3,3,1],
//  [1,4,6,4,1]
// ]


public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return result;
        }
        List<Integer> first = new ArrayList<Integer>();
        first.add(0, 1);
        result.add(0, first);
        for (int i = 1; i < numRows; i++ ) {
            List<Integer> prev = result.get(i - 1);
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.add(1);
            for (int j = 1; j < i; j++) {
                tmp.add(prev.get(j - 1) + prev.get(j));
            }
            tmp.add(1);
            result.add(tmp);
        }
        return result;
    }
}
