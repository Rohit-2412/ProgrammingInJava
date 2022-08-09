package DSA.Searching_Sorting;

import java.util.*;

public class SubsetSums {
    static List<Integer> v1;
    static List<Integer> v2;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, a, b;
        n = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        v1 = new ArrayList<>();
        v2 = new ArrayList<>();
        helper(arr, 0, (n / 2) - 1, v1);
        helper(arr, n / 2, n - 1, v2);
        
        Collections.sort(v2);
        Integer[] arr1 = v1.toArray(new Integer[0]);
        Integer[] arr2 = v2.toArray(new Integer[0]);
        
        int count = 0;
        for (Integer i : v1) {
            int low = lower_bound(arr2, a - i) - v2.get(0);
            int high = upper_bound(arr2, b - i) - v2.get(0);
            
            count += high - low;
        }
        
        System.out.println(count);
        
    }
    
    public static void helper(int[] arr, int st, int end, List<Integer> list) {
        int s = 0;
        int n = end - st + 1;
        
        for (int i = 0; i < (1 << n); i++) {
            s = 0;
            int j = st;
            int x = i;
            
            while (x != 0) {
                int l = x & 1;
                if (l != 0) s += arr[j];
                j++;
                x = x >> 1;
            }
            list.add(s);
        }
        
    }
    
    public static int lower_bound(Integer[] array, int key) {
        
        int index = Arrays.binarySearch(array, key);
        
        if (index < 0) {
            return Math.abs(index) - 1;
        }
        
        else {
            while (index > 0) {
                if (array[index - 1] == key) {
                    index--;
                }
                else {
                    return index;
                }
            }
            
            return index;
        }
    }
    public static int lower_bound(int[] array, int key) {
        
        int index = Arrays.binarySearch(array, key);
        
        if (index < 0) {
            return Math.abs(index) - 1;
        }
        
        else {
            while (index > 0) {
                if (array[index - 1] == key) {
                    index--;
                }
                else {
                    return index;
                }
            }
            
            return index;
        }
    }
    
    public static int upper_bound(Integer[] arr, int key) {
        int index = Arrays.binarySearch(arr, key);
        int n = arr.length;
        
        if (index < 0) {
            return Math.abs(index) - 1;
        }
        
        else {
            while (index < n) {
                if (arr[index] == key) {
                    index++;
                }
                
                else {
                    return index;
                }
            }
        }
        return index;
    }
    public static int upper_bound(int[] arr, int key) {
        int index = Arrays.binarySearch(arr, key);
        int n = arr.length;
        
        if (index < 0) {
            return Math.abs(index) - 1;
        }
        
        else {
            while (index < n) {
                if (arr[index] == key) {
                    index++;
                }
                
                else {
                    return index;
                }
            }
        }
        return index;
    }
}

