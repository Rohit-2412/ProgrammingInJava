package DSA.String;

public class ReverseString {
    public static void main(String[] args) {
        String s = "12345";
        System.out.println(reverse(s));
    }
    
    static String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
//        sb.append(s);
        sb.reverse();
        return sb.toString();
    }
    
}
