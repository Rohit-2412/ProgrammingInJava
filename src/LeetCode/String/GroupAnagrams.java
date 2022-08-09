package LeetCode.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] words) {
        // for each key we will store a list of strings as value
        HashMap<String, List<String>> map = new HashMap<>();
        for (String current : words) {
            // converting string to char array
            char[] characters = current.toCharArray();
            Arrays.sort(characters); // sorting all words
            String sortedStr = new String(characters);
            // now checking is this sorted word is present in our map or not
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(current); // adding original string back to the map at the same address
        }
        return new ArrayList<>(map.values());
    }
}
