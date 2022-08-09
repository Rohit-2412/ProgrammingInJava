// 07-07-2022 20:20 July

package LeetCode;

public class MaximumSwap {
    
    public int maximumSwap(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int[] idx = new int[10];
        for (int i = 0; i < arr.length; i++) {
            idx[arr[i] - '0'] = i;
        }
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 9; j > arr[i] - '0'; j--) {
                if (idx[j] > i) {
                    char temp = arr[i];
                    
                    arr[i] = arr[idx[j]];
                    arr[idx[j]] = temp;
                    
                    return Integer.parseInt(new String(arr));
                }
            }
        }
        
        return num;
    }
}