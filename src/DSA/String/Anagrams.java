package DSA.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
Print Anagrams Together
Medium Accuracy: 56.1% Submissions: 28083 Points: 4
Given an array of strings, return all groups of strings that are anagrams. The groups must be created in order of
their appearance in the original array. Look at the sample case for clarification.


Note: The finial output will be in lexicographic order.


Example 1:

Input:
N = 5
words[] = {act,god,cat,dog,tac}
Output:
act cat tac
god dog
Explanation:
There are 2 groups of
anagrams "god", "dog" make group 1.
"act", "cat", "tac" make group 2.
Example 2:

Input:
N = 3
words[] = {no,on,is}
Output:
no on
is
Explanation:
There are 2 groups of
anagrams "no", "on" make group 1.
"is" makes group 2.
 */
public class Anagrams {
    
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
