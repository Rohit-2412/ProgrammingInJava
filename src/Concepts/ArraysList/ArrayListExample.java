package Concepts.ArraysList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayListExample {
    public static void main(String[] args) {
//         ArrayList
//        initialization
        ArrayList<Integer> list = new ArrayList<>();
//        for adding elements
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);

//        for printing
        System.out.println(list);

//        for updating
        list.set(1, 50); // idx and value
        System.out.println(list);

//        for removing value
        list.remove(5);
        System.out.println(list);

//         to clear the whole list
//        list.clear();
//        System.out.println(list);
        // to check for an element
        System.out.println(list.contains(10));
        System.out.println(list.contains(150));
        
        int size = list.size();
        System.out.println(size);

//        for sorting
//        Collections.sort(list);
//        System.out.println(list);
//        list.sort(Comparator.reverseOrder());
        
        for (int i = 1; i <= 5; i++) {
            list.add(10 * i + 51);
        }
        System.out.println(list);
        Collections.sort(list);
//        System.out.println(list);
        
        Integer[] arr;
        arr = list.toArray(new Integer[0]);
        System.out.println("------");
        System.out.println(Arrays.toString(arr));
        
    }
}
