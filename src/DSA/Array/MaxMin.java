package DSA.Array;

public class MaxMin {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 1, 2, 3, 4,-99,999};
        int max = maxElement(arr);
        System.out.println(max);
        int min = minElement(arr);
        System.out.println(min);
    }
    
    private static int minElement(int[] arr) {
        int n = arr.length;
        int ans = Integer.MAX_VALUE;
        for (int num : arr)
            if (num <= ans) {
                ans = num;
            }
        return ans;
    }
    
    private static int maxElement(int[] arr) {
        int n = arr.length;
        int ans = Integer.MIN_VALUE;
        for (int num : arr)
            if (num >= ans) {
                ans = num;
            }
        return ans;
    }
    
}
