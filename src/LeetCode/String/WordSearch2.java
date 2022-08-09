package LeetCode.String;
/*
Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or
vertically neighboring. The same letter cell may not be used more than once in a word.
 */

import java.util.ArrayList;
import java.util.List;

public class WordSearch2 {
    static boolean dfs(char[][] board, int i, int j, int count, String word) {
        if (word.length() == count) return true;
        
        if (i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(count)) {
            return false;
        }
        
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
    // using dfs will return TLE
    public static List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();
        int k = 0;
        while (k < words.length) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    char c = board[i][j];
                    if (c == words[k].charAt(0) && dfs(board, i, j, 0, words[k])) {
                        if (!list.contains(words[k])) list.add(words[k]);
                    }
                }
            }
            k++;
        }
        return list;
    }
    
    // using trie approach
    
}
