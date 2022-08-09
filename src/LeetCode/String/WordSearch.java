package LeetCode.String;

/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or
vertically neighboring. The same letter cell may not be used more than once.
 */
public class WordSearch {
    
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if (c == word.charAt(0) && dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    static boolean dfs(char[][] board, int i, int j, int count, String word) {
        if (word.length() == count) return true;
        
        if (i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j]!=word.charAt(count)) return false;
        
        char temp = board[i][j];
        board[i][j] = ' ';
        boolean found =
                dfs(board, i + 1, j, count + 1, word) ||
                dfs(board, i - 1, j, count + 1, word) ||
                dfs(board, i, j + 1, count + 1, word) ||
                dfs(board, i, j - 1, count + 1, word);
        
        board[i][j] = temp;
        return found;
    }
}
