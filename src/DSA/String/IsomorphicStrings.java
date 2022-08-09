package DSA.String;

import java.util.HashMap;

public class IsomorphicStrings {
    
    public static void main(String[] args) {
        System.out.println(areIsomorphic("aab", "yya"));
    }
    
    public static boolean areIsomorphic(String str1, String str2) {
        HashMap<Character, Character> map = new HashMap<>();
        
        if (str1.length() != str2.length()) return false;
        
        int n = str1.length();
        
        for (int i = 0; i < n; i++) {
            // Checking if map already has the key present.
            if (map.containsKey(str1.charAt(i))) {
                // Comparing if the value matches with the already present value.
                if (map.get(str1.charAt(i)) != str2.charAt(i)) {
                    return false;
                }
            }
            
            // if value already exists
            else {
                // if value already exists means we have found a wrong pair
                if (map.containsValue(str2.charAt(i))) {
                    return false;
                }
                // if it doesn't exist then add it to map
                map.put(str1.charAt(i), str2.charAt(i));
            }
            
        }
        return true;
    }
}
