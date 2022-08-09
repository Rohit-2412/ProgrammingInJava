package LeetCode.String;

public class StringToInteger {
    
    public static void main(String[] args) {
        System.out.println(strToInt("2147483648"));
    }
    
    static int strToInt(String s) {
        if (s == null || s.isEmpty()) {
            // empty strings are null
            return 0;
        }
    
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') ++i; // skip leading white space
        if (i >= s.length()) { // check if we're still within the string boundaries
            return 0;
        }
    
        int sign = 1;
    
        // fall-through logic, covers sign indicator if present, while incrementing the index if needed.
        switch (s.charAt(i)) {
            case '-': sign = -1; // negative number, flip sign
            case '+': ++i; // positive number, increment index
            default:  break; // neither, might be number, don't keep current index
        }
    
        long sum = 0L; // use long to cover out of boundary cases and not overflow the sum
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            sum = sum * 10 + (s.charAt(i) - '0');
            ++i;
        
            if (sum > Integer.MAX_VALUE) {
                // if we passed max integer value, check the sign and return correct value
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
    
        // return calculated value with sign
        return sign * (int) sum;
    }
}
