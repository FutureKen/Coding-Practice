public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        dfs(res, 0, board);
        return res;
    }
    private void dfs(List<List<String>> res, int col, char[][] board) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (isValid(board, i, col)) {
                board[i][col] = 'Q';
                dfs(res, col + 1, board);
                board[i][col] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int r, int c) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < c; j++) {
                //Check if they are on same row or both / and \ diagonal directions.
                if (board[i][j] == 'Q' && (i == r || i + j == r + c || i - j == r - c)) {
                    return false;
                }
            }
        }
        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> solution = new ArrayList<String>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            solution.add(s);
        }
        return solution;
    }
}