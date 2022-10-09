package DSA.Array;

import java.util.ArrayList;

public class CommonElement {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 10, 20, 40, 80};
        int[] b = {1, 2, 3, 4, 5, 6, 7, 20, 80, 100};
        int[] c = {1, 2, 3, 4, 5, 15, 20, 30, 70, 80, 120};
        System.out.println(commonElements(a, b, c, a.length, b.length, c.length));
    }
    
    public static ArrayList<Integer> commonElements(int[] nums1, int[] nums2, int[] nums3, int n1, int n2, int n3) {
        // code here
        ArrayList<Integer> common = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2 && k < n3) {
            if (nums1[i] == nums2[j] && nums2[j] == nums3[k]) {
                if (!common.contains(nums1[i])) {
                    common.add(nums1[i]);
                }
                i++;
                j++;
                k++;
            }
            else if (nums1[i] < nums2[j]) {
                i++;
            }
            else if (nums2[j] < nums3[k]) {
                j++;
            }
            else {
                k++;
            }
        }
        return common;
    }
}
