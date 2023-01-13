package DSA.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestCommonSubseq {
    public static void main(String[] args) {
        // int[] arr = {2, 6, 1, 9, 4, 5, 3};
        int[] arr = { 1 };
        System.out.println(findLongestConseqSubseq(arr, arr.length));
    }

    static int findLongestConseqSubseq(int[] arr, int N) {
        // add your code here
        if (arr.length == 1)
            return 1;
        Set<Integer> map = new HashSet<>();
        for (int i = 0; i < N; i++) {
            map.add(arr[i]);
        }
        Integer[] elements = map.toArray(new Integer[0]);
        Arrays.sort(elements);
        int max = Integer.MIN_VALUE;
        int count = 1;
        for (int i = 1; i < elements.length; i++) {
            if (elements[i] - elements[i - 1] == 1) {
                count++;
            } else {
                count = 1;
            }

            if (count > max)
                max = count;
        }
        return max;
    }
}
