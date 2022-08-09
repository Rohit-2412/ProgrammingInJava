package LeetCode.Stack;

import java.util.ArrayList;

public class CircularGame {
    public static void main(String[] args) {
        System.out.println(findTheWinner(7, 5));
    }
    
    public static int findTheWinner(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1); // putting values as friend number
        }
        int start = 0;
        while (list.size() != 1) {
            // System.out.println(list);
            int idx = (start + k - 1) % list.size(); // getting idx of friend to remove
            list.remove(idx); // removing the friend
            start = (idx++) % list.size(); // next friend's idx
        }
        return (int) list.get(0);
    }
}
