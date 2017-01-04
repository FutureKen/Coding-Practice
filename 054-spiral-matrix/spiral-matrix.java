// Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
//
//
//
// For example,
// Given the following matrix:
//
//
// [
//  [ 1, 2, 3 ],
//  [ 4, 5, 6 ],
//  [ 7, 8, 9 ]
// ]
//
//
// You should return [1,2,3,6,9,8,7,4,5].


public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }
        int rowStart = 0, rowEnd = matrix.length - 1, colStart = 0, colEnd = matrix[0].length - 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            //Go right
            for (int i = colStart; i <= colEnd; i++) {
                result.add(matrix[rowStart][i]);
            }
            rowStart++;
            //Go down
            for (int i = rowStart; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);     
            }
            colEnd--;

            if (rowStart > rowEnd || colStart > colEnd) {
                break;
            }

            //Go left
            for (int i = colEnd; i >= colStart; i--) {
                result.add(matrix[rowEnd][i]);
            }
            rowEnd--;
            //Go up
            for (int i = rowEnd; i >= rowStart; i--) {
                result.add(matrix[i][colStart]);
            }
            colStart++;
        }
        return result;
    }
}
