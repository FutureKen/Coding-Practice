// Given a 2D board and a word, find if the word exists in the grid.
//
//
// The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
//
//
//
// For example,
// Given board = 
//
// [
//   ['A','B','C','E'],
//   ['S','F','C','S'],
//   ['A','D','E','E']
// ]
//
//
// word = "ABCCED", -> returns true,
// word = "SEE", -> returns true,
// word = "ABCB", -> returns false.


public class Solution {
    public boolean exist(char[][] board, String word) {
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (search(board, word, y, x, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int y, int x, int found) {
        if (found == word.length()) {
            return true;
        }
        if (y > board.length - 1 || y < 0 || x > board[0].length - 1 || x < 0 || board[y][x] != word.charAt(found)) {
            return false;
        }
        board[y][x] = '*';
        boolean result = search(board, word, y - 1, x, found + 1) || search(board, word, y + 1, x, found + 1) || search(board, word, y, x + 1, found + 1) || search(board, word, y, x - 1, found + 1);
        board[y][x] = word.charAt(found);
        return result;
    }
}
