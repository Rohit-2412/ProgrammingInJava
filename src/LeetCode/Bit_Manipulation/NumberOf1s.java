package LeetCode.Bit_Manipulation;

public class NumberOf1s {
    public int hammingWeight(int n) {
        int count = 0;
        // 32 bits so for loop 32 times
        for (int i = 0; i < 32; i++) {
            // getting the leftmost bit
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }
}
