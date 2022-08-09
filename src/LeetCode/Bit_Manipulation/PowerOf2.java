package LeetCode.Bit_Manipulation;

public class PowerOf2 {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(16));
    }
    
    public static boolean isPowerOfTwo(int n) {
        // AND with (n-1) gives 0 (if n is a power of 2)
        // reason : power of 2 is represented as 10000..000 (ony one 1 at rightmost place)
        // (n-1) gives all bit as 1 except that bit which was previously 1,so AND will cancel all and gives 0000000000
        return n > 0 && (n & n - 1) == 0;
    }
}
