// Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
//
//
// For example, given the following triangle
//
// [
//      [2],
//     [3,4],
//    [6,5,7],
//   [4,1,8,3]
// ]
//
//
//
// The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
//
//
//
// Note:
// Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.


public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        if (rows == 0) {
            return 0; 
        }
        int[] min = new int[rows];
        //Add last row to min;
        for (int i = 0; i < triangle.get(rows - 1).size(); i++) {
            min[i] = triangle.get(rows - 1).get(i);
        }

        //Go from bottom to top;
        for (int i = rows - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                min[j] = Math.min(min[j], min[j + 1]) + triangle.get(i).get(j);
            }
        }
        return min[0];
    }
}
