package DSA.String;

import java.util.Arrays;

public class PatternSearching {
    
    static int NO_OF_CHARS = 256;
    
    
    //The preprocessing function for Boyer Moore's
    //bad character heuristic
    static void badCharHeuristic(char[] str, int size, int[] badCharacter) {
        
        // Initialize all occurrences as -1
        for (int i = 0; i < NO_OF_CHARS; i++)
            badCharacter[i] = -1;
        
        // Fill the actual value of last occurrence
        // of a character (indices of table are ascii and values are index of occurrence)
        for (int i = 0; i < size; i++)
            badCharacter[str[i]] = i;
    }
    
    /* A pattern searching function that uses Bad
    Character Heuristic of Boyer Moore Algorithm */
    static void search(char[] text, char[] pattern) {
        int m = pattern.length;
        int n = text.length;
        
        int[] badChar = new int[NO_OF_CHARS];
 
      /* Fill the bad character array by calling
         the preprocessing function badCharHeuristic()
         for given pattern */
        badCharHeuristic(pattern, m, badChar);
        
        int s = 0;  // s is shift of the pattern with
        // respect to text
        //there are n-m+1 potential alignments
        while (s <= (n - m)) {
            int j = m - 1;
 
          /* Keep reducing index j of pattern while
             characters of pattern and text are
             matching at this shift s */
            while (j >= 0 && pattern[j] == text[s + j])
                j--;
 
          /* If the pattern is present at current
             shift, then index j will become -1 after
             the above loop */
            if (j < 0) {
                System.out.println("Patterns occur at shift = " + s);
 
              /* Shift the pattern so that the next
                 character in text aligns with the last
                 occurrence of it in pattern.
                 The condition s+m < n is necessary for
                 the case when pattern occurs at the end
                 of text */
                //txt[s+m] is character after the pattern in text
                s += (s + m < n) ? m - badChar[text[s + m]] : 1;
                
            }
            
            else
              /* Shift the pattern so that the bad character
                 in text aligns with the last occurrence of
                 it in pattern. The max function is used to
                 make sure that we get a positive shift.
                 We may get a negative shift if the last
                 occurrence  of bad character in pattern
                 is on the right side of the current
                 character. */ {
                s += Math.max(1, j - badChar[text[s + j]]);
            }
        }
        System.out.println(Arrays.toString(badChar));
    }
    
    /* Driver program to test above function */
    public static void main(String[] args) {
        
        char[] text = "patternABCabcDEFdef".toCharArray();
        char[] pattern = "abc".toCharArray();
        search(text, pattern);
    }
    
}
