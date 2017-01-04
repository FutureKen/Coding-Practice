// Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
//
//
//
// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previous row.
//
//
//
//
// For example,
//
// Consider the following matrix:
//
//
// [
//   [1,   3,  5,  7],
//   [10, 11, 16, 20],
//   [23, 30, 34, 50]
// ]
//
//
// Given target = 3, return true.


public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int end = rows * cols - 1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (matrix[mid / cols][mid % cols] == target ) {
                return true;
            } else if (matrix[mid / cols][mid % cols] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
