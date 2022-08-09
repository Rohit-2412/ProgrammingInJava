package DSA.String;

import java.util.Objects;

import static java.lang.System.out;

/*
Recursively print all sentences that can be formed from list of word lists

Given a list of word lists How to print all sentences possible taking one word from a list at a time via recursion?
 */
public class PossibleSentences {
    static final int R = 3;
    static final int C = 3;
    
    public static void main(String[] args) {
        String[][] arr = {{"you", "we", ""},
                          {"have", "are", ""},
                          {"sleep", "eat", "drink"}};
        
        print(arr);
        
    }
    
    
    static void print(String[][] arr) {
        String[] output = new String[arr.length];
        for (int i = 0; i < C; i++) {
            if (!Objects.equals(arr[0][i], "")) printSentence(arr, 0, i, output);
        }
    }
    
    // m = rows;
    // n = columns
    static void printSentence(String[][] arr, int m, int n, String[] output) {
        // current word
        output[m] = arr[m][n];
        
        // printing last row
        if (m == R - 1) {
            for (int i = 0; i < R; i++) {
                out.print(output[i] + " ");
            }
            out.println();
            return;
        }
        
        // calling for next rows
        for (int i = 0; i < C; i++) {
            if (!Objects.equals(arr[m + 1][i], "") && m < C) {
                printSentence(arr, m + 1, i, output);
            }
        }
    }
}
