package DSA.String;

import java.util.ArrayList;
import java.util.List;

// Program to print all the subsequences of a string.
public class Subsequences {
    static List<String> list = new ArrayList<>();
    
    public static void main(String[] args) {
        String s = "Java";
        printSubsequences(s, "");
        System.out.println(list);
        System.out.println(list.size());
    }
    
    static void printSubsequences(String s, String result) {
        if (s.length() == 0) {
            list.add(result);
            return;
        }
        printSubsequences(s.substring(1), result + s.charAt(0));
        printSubsequences(s.substring(1), result);
    }
}
