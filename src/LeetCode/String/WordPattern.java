package LeetCode.String;

import java.util.HashMap;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" "); // split all the words after spaces into a new word and add it to array
        if (words.length != pattern.length()) return false;
        
        HashMap<Character, String> map = new HashMap<>(); // we will map each word to a character of pattern
        
        for (int i = 0; i < pattern.length(); i++) {
            char current_char = pattern.charAt(i); // getting the current character of pattern
            if (map.containsKey(current_char)) {
                // if map already has the key then get the value at that key and compare it to current word
                // if it's not the same value then, return false (pattern broken)
                if (!map.get(current_char).equals(words[i])) {
                    return false;
                }
            }
            else {
                // if there is mapping with different character then it's also wrong
                if (map.containsValue(words[i])) return false;
                // if word is not present or not mapped then add it to map
                map.put(current_char, words[i]);
            }
        }
        return true;
        
    }
}
