package LeetCode.Bit_Manipulation;

public class ReverseBits {
    public int reverseBits(int n) {
        int val = 0;
        int i = 1; // bit's place
        while (i <= 32) {
            val = val << 1; // left shift by 1
            val = val | (n & 1);
            n = n >> 1; // placing reverse of current bit in answer
            i++;
        }
        return val;
    }
}
