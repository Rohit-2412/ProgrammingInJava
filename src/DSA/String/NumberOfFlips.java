package DSA.String;

/*
Given a binary string, that is it contains only 0s and 1s. We need to make this string a sequence of alternate
characters by flipping some bits, our goal is to minimize the number of bits to be flipped.
 */
public class NumberOfFlips {
    // 10101010101
    
    public static void main(String[] args) {
        System.out.println(minFlips("001"));
    }
    
    // array : 0 1 0 1 0 1 0 1 0 1
    // index : 0 1 2 3 4 5 6 7 8 9
    
    public static int minFlips(String s) {
        int cnt1 = 0;
        int cnt0 = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // odd index
            if ((i & 1) == 1) {
                if (s.charAt(i) != '0') cnt1++;
                if (s.charAt(i) != '1') cnt0++;
            }
            // even index
            else {
                if (s.charAt(i) != '1') cnt1++;
                if (s.charAt(i) != '0') cnt0++;
            }
        }
        return Math.min(cnt0,cnt1);
    }
}
