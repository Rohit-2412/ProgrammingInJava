package Concepts.Binary_Search;

import java.util.ArrayList;

public class OrderAgnosticBS {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 12; i > 1; i--) {
            list.add(2 * i);
        }
//        for checking ascending and descending order of list
        boolean isAsc = list.get(0) < list.get(list.size() - 1);
        
        System.out.println(orderAgnosticBinary_Search(list, 6));
        System.out.println(list);
    }
    
    static int orderAgnosticBinary_Search(ArrayList<Integer> list, int value) {
        int l = 0, r = list.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) == value) {
                return mid;
            } else if (list.get(mid) > value) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
