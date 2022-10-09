package DSA.Array;

import java.util.HashMap;

public class UnionIntersection {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3, 4, 5};
//        System.out.println(doUnion(arr1, arr1.length, arr2, arr2.length));
        System.out.println(doIntersection(arr1, arr1.length, arr2, arr2.length));
    }
    
    public static int doIntersection(int[] arr1, int n, int[] arr2, int m) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int num : arr1) {
            map.put(num, map.getOrDefault(num, 1));
        }
        for (int num : arr2) {
            if (map.containsKey(num)) {
                ans++;
            }
        }
        return ans;
    }
    
    public static int doUnion(int[] arr1, int n, int[] arr2, int m) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr1) {
            map.put(num, map.getOrDefault(num, 1));
        }
        for (int num : arr2) {
            if (!map.containsKey(num)) {
                map.put(num, map.getOrDefault(num, 1));
            }
        }
        return map.size();
    }
}
