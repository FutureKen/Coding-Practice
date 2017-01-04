// Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
//
//
// For example,
// Given n = 3,
//
// You should return the following matrix:
//
// [
//  [ 1, 2, 3 ],
//  [ 8, 9, 4 ],
//  [ 7, 6, 5 ]
// ]


public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if (n == 0) {
            return res;
        }
        int rowStart = 0, rowEnd = n - 1, colStart = 0, colEnd = n - 1, no = 1;
        while (rowStart <= rowEnd &&  colStart <= colEnd) {
            //Go right
            for (int i = colStart; i <= colEnd; i++) {
                res[rowStart][i] = no++;
            }
            rowStart++;
            //Go down
            for (int i = rowStart; i <= rowEnd; i++) {
                res[i][colEnd] = no++;
            }
            colEnd--;

            //Go left
            for (int i = colEnd; i >= colStart; i--) {
                res[rowEnd][i] = no++;
            }
            rowEnd--;
            //Go up
            for (int i = rowEnd; i >= rowStart; i--) {
                res[i][colStart] = no++;
            }
            colStart++;
        }
        return res;
    }
}
