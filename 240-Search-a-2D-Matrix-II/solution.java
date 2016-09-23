public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int n = col - 1;
        int m = 0;
        while (n >= 0 && m < row) {
            if (matrix[m][n] == target) {
                return true;
            } else if (matrix[m][n] < target) {
                m++;
            } else {
                n--;
            }
        }
        return false;
    }
}