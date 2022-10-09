package DSA.String;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddress {
    
    public static void main(String[] args) {
        System.out.println(IP("25525511135"));
    }
    
    static List<String> IP(String s) {
        List<String> result = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        findValid(s, curr, result);
        return result;
    }
    
    private static void findValid(String s, List<String> curr, List<String> result) {
        if (s.equals("")) return;
        
        // if we already have set of 3 valid IP address then remaining string would be the last IP address,
        // so we will check if It's valid or not
        // then we will add it to the current list
        if (curr.size() == 3) {
            if (checkValid(s)) {
    
                result.add(curr.get(0) + "." + curr.get(1) + "." + curr.get(2) + "." + s);
            }
            return;
        }
        
        // trying out all possible combination of
        // substrings of length 1 2 3
        for (int i = 1; i < Math.min(s.length(), 4); i++) {
            
            if (checkValid(s.substring(0, i))) {
                curr.add(s.substring(0, i));
                
                findValid(s.substring(i), curr, result);
                
                curr.remove(curr.size() - 1);
            }
        }
        
    }
    
    private static boolean checkValid(String s) {
        if (s.length() > 3 || s.length() > 1 && s.charAt(0) == '0') return false;
        
        int num = Integer.parseInt(s);
    
        return num >= 0 && num <= 255;
    }
    
}
    
