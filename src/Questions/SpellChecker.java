package Questions;

import javax.print.attribute.HashAttributeSet;
import java.util.Objects;

public class SpellChecker {
// Re-write the spellcheck(word, dictionary) (and optionally the printStartsWith(firstLetters, dictionary)) methods
// to use enhanced for-each loops.
    
    // main function
    public static void main(String[] args) {
        String[] dictionary = {"the", "of", "and", "a", "to", "in", "is", "you", "that", "it", "he", "was", "for",
                               "on", "are", "as", "with", "his", "they", "I", "at", "be", "this", "have", "from", "or"
                , "one", "had", "by", "word", "but", "not", "what", "all", "were", "we", "when", "your", "can", "said"
                , "there", "use", "an", "each", "which", "she", "do", "how", "their", "if", "will", "up", "other",
                               "about", "out", "many", "then", "them", "these", "so", "some", "her", "would", "make",
                               "like", "him", "into", "time", "has", "look", "two", "more", "write", "go", "see",
                               "number", "no", "way", "could", "people", "my", "than", "first", "water", "been",
                               "call", "who", "oil", "its", "now", "find", "long", "down", "day", "did", "get", "come"
                , "made", "may", "cat", "dog", "cats", "dogs"};
        
        // Uncomment to test your method
        String word = "catz";
        // if word is found in dictionary
        if (checker.spellcheck(word, dictionary)) {
            // printing required message
            System.out.println(word + " is spelled correctly!");
        }
        else {
            System.out.println(word + " is misspelled!");
        }
        
        
        // Optional (not auto graded)
        // printing string starting with `a`
        checker.printStartsWith("a", dictionary);
    }
    
    static class checker {
        // function to find if a word is present in array `dictionary`
        static boolean spellcheck(String word, String[] dictionary) {
            // iterating through each word in array dictionary
            for (String s : dictionary) {
                // if s is equal to word
                if (Objects.equals(s, word)) {
                    // returning true
                    return true;
                }
            }
            return false;
        }
        
        // function to print words starting with string `a`
        public static void printStartsWith(String a, String[] dictionary) {
            // iterating over each word in array dictionary
            for (String s : dictionary) {
                if (s.startsWith(a)) {
                    System.out.println(s);
                }
            }
        }
    }
}