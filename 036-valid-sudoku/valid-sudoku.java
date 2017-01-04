// Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
//
// The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
//
//
//
// A partially filled sudoku which is valid.
//
//
// Note:
// A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.


public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            //Check current column;
            if (!PartialChecker(board, i, i, 0, 8)) {
                return false;
            }
            //Check current row;
            if (!PartialChecker(board, 0, 8, i, i)) {
                return false;
            }
        }
        //Check 9 sub-matrix;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!PartialChecker(board, i * 3, i * 3 + 2, j * 3, j * 3 + 2)) {
                    return false;
                }
            }           
        }
        return true;
    }

    private boolean PartialChecker(char[][] board, int x1, int x2, int y1, int y2) {
        HashSet set = new HashSet();
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (board[i][j] != '.') {
                    if (set.contains(board[i][j])) {
                        return false;
                    } else {
                        set.add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }
}
