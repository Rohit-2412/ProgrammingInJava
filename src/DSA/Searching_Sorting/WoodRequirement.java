package DSA.Searching_Sorting;

import java.util.Scanner;

public class WoodRequirement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        num = sc.nextInt();
        int wood;
        wood = sc.nextInt();
        int[] tree = new int[num];
        for (int i = 0; i < num; i++) {
            tree[i] = sc.nextInt();
        }
        System.out.println(woodCutter(tree, wood));
    }
    
    public static int woodCutter(int[] tree, int required) {
        int low = 0;
        int high = Integer.MIN_VALUE;
        
        for (int val : tree) {
            high = Math.max(high, val);
        }
        int wood, mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            wood = 0;
            for (int val : tree) {
                if (val > mid) {
                    wood += (val - mid);
                }
            }
            if (wood < required) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return mid - 1;
    }
}
