package LeetCode.Array;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(majority(arr));
    }
    
    public static int majority(int[] nums) {
        // Moore's Voting Algorithm
        int count = 0, res = 0;
        for (int num : nums) {
            if (count == 0) {
                res = num;
            }
            if (num == res) {
                count++;
            }
            else {
                count--;
            }
        }
        return res;
    }
}
