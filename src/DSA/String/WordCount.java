package DSA.String;

public class WordCount {
    
    public static void main(String[] args) {
        String needle = "MAGIC";
        String[] input = {"BBABBM", "CBMBBA",
                          "IBABBG", "GOZBBI",
                          "ABBBBC", "MCIGAM"};
        char[][] str = new char[6][6];
        
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length(); j++) {
                str[i][j] = input[i].charAt(j);
            }
        }
        
        System.out.println(count(str, needle));
    }
    
    static int count(char[][] board, String word) {
        int ans = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (word.charAt(0) == board[i][j] && dfs(board, i, j, 0, word)) {
                    ans++;
                }
            }
        }
        return ans;
    }
    
    private static boolean dfs(char[][] board, int i, int j, int count, String word) {
        if (count == word.length()) return true;
        
        if (i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(count)) {
            return false;
        }
        
        char temp = board[i][j];
        board[i][j] = ' ';
        boolean found = dfs(board, i + 1, j, count + 1, word) ||
                dfs(board, i - 1, j, count + 1, word) ||
                dfs(board, i, j + 1, count + 1, word) ||
                dfs(board, i, j - 1, count + 1, word);
        
        board[i][j] = temp;
        
        return found;
    }
}
