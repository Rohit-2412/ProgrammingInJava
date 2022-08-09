package DSA.String;

public class CheckRotation {
    
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "acbd";
        System.out.println(isRotated(s1, s2));
    }
    
    static boolean isRotated(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        // let S1 = main string
        // s2 = rotated string
        int k = 0;
        char ch = s1.charAt(0);
        while (ch != s2.charAt(k)) {
            k++;
        }
        for (int i = 0; i < s1.length(); i++) {
            k %= s2.length();
            if (s1.charAt(i) != s2.charAt(k)) {
                return false;
            }
            k++;
        }
        return true;
    }
}
