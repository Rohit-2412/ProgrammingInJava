package DSA.Array;

import java.util.ArrayList;
import java.util.Arrays;

public class ElementsOccurrence {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 2, 1, 2, 3, 3};
        System.out.println(findOccurrences(arr, 4));
    }
    
    static ArrayList<Integer> findOccurrences(int[] arr, int k) {
        /*
        approach 1 : using hash table
        
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
            if (map.get(num) > ((arr.length) / k)) {
                if (!result.contains(num)) {
                    result.add(num);
                }
            }
        }
        return result;
*/

//        Time Complexity: O(nk)
//        Auxiliary Space: O(k)


// declaring class objects array for storing top k-1 element with their frequency

//        element[] group = new element[k - 1];
//        for (int i = 0; i < k - 1; i++) {
//            group[i] = new element();
//            group[i].count = 0;
//        }
//        for (int i = 0; i < arr.length; i++) {
//            // traversing each element of array
//            int j;
///*
//            If arr[i] is already present in
//            the element count array,
//            then increment its count
//*/
//            for (j = 0; j < k - 1; j++) {
//                if (group[j].ele == arr[i]) {
//                    group[j].count++;
//                    break;
//                }
//            }
//            // if element is not present in group Array
//            if (j == k - 1) {
//                int l;
//                // if there is any space left in the group then add the element and update count to 1
//                for (l = 0; l < k - 1; l++) {
//                    if (group[l].count == 0) {
//                        group[l].ele = arr[i];
//                        group[l].count = 1;
//                        break;
//                    }
//                }
//                // if no space is left then decrement the count of all members by 1
//                if (l == k - 1) {
//                    for (l = 0; l < k - 1; l++) {
//                        group[i].count--;
//                    }
//                }
//            }
//        }
//        ArrayList<Integer> record = new ArrayList<>();
//        for (int i = 0; i < k - 1; i++) {
//            int actualCount = 0;
//            for (int value : arr) {
//                if (value == group[i].ele) actualCount++;
//            }
//            if (actualCount > arr.length / k) record.add(arr[i]);
//        }
//        return record;

//        using sorting
//        time : O(nlog(n)) + O(n)
        Arrays.sort(arr);
        int x = arr.length / k;
        int count = 1;
        ArrayList<Integer> integers = new ArrayList<>();
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (temp == arr[i]) {
                count++;
            }
            else {
                temp = arr[i];
                count = 1;
            }
            if (count > x) {
                if (!integers.contains(arr[i])) {
                    integers.add(arr[i]);
                }
            }
        }
        return integers;
    }
    
    static class element {
        int ele;
        int count;
    }
}
