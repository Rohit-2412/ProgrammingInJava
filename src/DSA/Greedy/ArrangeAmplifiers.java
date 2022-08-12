// 10-08-2022 22:31 August

package DSA.Greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ArrangeAmplifiers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        int ones = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] == 1) ones++;
        }
        Arrays.sort(arr, Collections.reverseOrder());
        for (int i = 0; i < ones; i++) {
            System.out.print("1 ");
        }
        
        for (int i = ones; i < n; i++) {
            if (arr[i] == 3 && arr[i + 1] == 2) {
                System.out.print("2 3 ");
                i++;
            }
            else {
                System.out.print(arr[i] + " ");
            }
        }
        
    }
    
    
}
