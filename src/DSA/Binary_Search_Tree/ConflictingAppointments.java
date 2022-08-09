package DSA.Binary_Search_Tree;

import java.util.ArrayList;
import java.util.Comparator;

public class ConflictingAppointments {
    public static void main(String[] args) {
        ArrayList<int[]> al = new ArrayList<>();
        al.add(new int[] {1, 5});
        al.add(new int[] {3, 7});
        al.add(new int[] {2, 6});
        al.add(new int[] {10, 15});
        al.add(new int[] {5, 6});
        al.add(new int[] {4, 100});
        
        overlapCount(al);
    }
    
    // using Interval Tree -> in IntervalTree.java
    static void overlapCount(ArrayList<int[]> al) {
        
        al.sort(Comparator.comparingInt(a -> a[0]));
        
        int conflict = 0;
        
        for (int i = 0; i < al.size() - 1; i++) {
            int[] curr = al.get(i);
            int[] nxt = al.get(i + 1);
            if (curr[1] > nxt[0] && curr[0] < nxt[1]) {
                conflict++;
            }
        }
        System.out.println("Conflicts: " + conflict);
    }
    
}
