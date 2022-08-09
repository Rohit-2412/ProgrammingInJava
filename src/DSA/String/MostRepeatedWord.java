package DSA.String;

/*
Second most repeated string in a sequence
Given a sequence of strings, the task is to find out the second most repeated (or frequent) string in the given
sequence.

Note: No two strings are the second most repeated, there will be always a single string.
 */

import java.util.HashMap;
import java.util.Map;

public class MostRepeatedWord {
    String secFrequent(String[] arr, int N) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            map.putIfAbsent(s, 0);
            
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            }
        }
        
        int max = 0;
        for (String s : map.keySet()) {
            if (map.get(s) > max) max = map.get(s);
        }
        
        String str = "";
        int sec = 0;
        for(String s:map.keySet()){
            if(map.get(s) < max && map.get(s) > sec){
                sec = map.get(s);
                str = s;
            }
        }
        return str;
    }
    
}
