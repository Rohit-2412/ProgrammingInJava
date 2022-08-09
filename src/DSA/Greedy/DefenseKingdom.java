// 07-08-2022 01:46 August

package DSA.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DefenseKingdom {
    public static void main(String[] args) {
        int w, h, n;
        Scanner scanner = new Scanner(System.in);
        w = scanner.nextInt();
        h = scanner.nextInt();
        n = scanner.nextInt();
        
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        
        a.add(0);
        b.add(0);
        for (int i = 0; i < n; i++) {
            a.add(scanner.nextInt());
            b.add(scanner.nextInt());
        }
        
        a.add(w);
        b.add(h);
        
        Collections.sort(a);
        Collections.sort(b);
        
        int maxH = 0;
        int maxW = 0;
        
        for (int i = 0; i < a.size() - 1; i++) {
            maxH = Math.max(a.get(i + 1) - a.get(i) - 1, maxH);
            maxW = Math.max(b.get(i + 1) - b.get(i) - 1, maxW);
        }
        
        System.out.println(maxW * maxH);
//        System.out.println(maxW);
//        System.out.println(maxH);
    }
    
    
}
