package DSA.Array;

import java.util.Arrays;

public class MinimiseMaximumDiff {

  public static void main(String[] args) {
    int[] arr = { 3, 9, 12, 16, 20 };
    int n = 5, k = 3;
    System.out.println(getMinDiff(arr, n, k));
  }

  public static int getMinDiff(int[] arr, int n, int k) {
    Arrays.sort(arr);
    // potential answer will be difference of smallest and largest element
    int ans = arr[n - 1] - arr[0];
    int tempMax = arr[n - 1] - k; // temp variables after modifying height of tower by "k"
    int tempMin = arr[0] + k; // temp variables after modifying height of tower by "k"
    int max = 0, min = 0;
    for (int i = 0; i < n - 1; i++) {
      max = Math.max(arr[i] + k, tempMax);
      min = Math.min(arr[i + 1] - k, tempMin);
      if (min < 0) continue;
      ans = Math.min(ans, max - min);
    }
    return ans;
  }
}
