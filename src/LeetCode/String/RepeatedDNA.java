package LeetCode.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNA {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> repeatedDNA = new ArrayList<>(); // ans list
        Map<String, Integer> seen = new HashMap<>();  // hashmap
        int i = 0;
        // checking if we have substring of length 10
        while (i + 10 <= s.length()) {
            String s1 = s.substring(i, i++ + 10); // getting substring from i to 10 more chars
            seen.put(s1, seen.getOrDefault(s1, 0) + 1); // putting the current substr to hashmap
            // if we have encountered the same string twice then we will add this substring to ans list
            if (seen.get(s1) == 2) {
                repeatedDNA.add(s1);
            }
        }
        return repeatedDNA;
    }
}
