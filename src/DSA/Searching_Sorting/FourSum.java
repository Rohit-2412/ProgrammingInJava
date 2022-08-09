package DSA.Searching_Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {
    
    static ArrayList<ArrayList<Integer>> fourSum(int[] arr, int key) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        if (n == 0) return ans;
        
        Arrays.sort(arr);
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum_ij = key - arr[i] - arr[j];
                
                int low = j + 1;
                int high = n - 1;
                
                while (low < high) {
                    int temp_sum = arr[low] + arr[high];
                    if (temp_sum < sum_ij) {
                        low++;
                    }
                    else if (temp_sum > sum_ij) {
                        high--;
                    }
                    else {
                        ArrayList<Integer> sub = new ArrayList<>();
                        sub.add(arr[i]);
                        sub.add(arr[j]);
                        sub.add(arr[low]);
                        sub.add(arr[high]);
                        ans.add(sub);
                        
                        while (sub.get(2) == arr[low] && low < high) {
                            low++;
                        }
                        while (sub.get(3) == arr[high] && low < high) {
                            high--;
                        }
                    }
                    while (j + 1 < n && arr[j + 1] == arr[j])
                        j++;
                }
                while (i + 1 < n && arr[i + 1] == arr[i]) i++;
            }
        }
        return ans;
    }
}
