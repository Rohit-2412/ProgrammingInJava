package DSA.Binary_Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/*
Check Mirror in N-ary tree
Medium Accuracy: 53.24% Submissions: 12652 Points: 4
Given two n-ary trees. Check if they are mirror images of each other or not. You are also given e denoting the number
 of edges in both trees, and two arrays, A[] and B[]. Each array has 2*e space separated values u,v denoting an edge
 from u to v for the both trees.


Example 1:

Input:
n = 3, e = 2
A[] = {1, 2, 1, 3}
B[] = {1, 3, 1, 2}
Output:
1
Explanation:
   1          1
 / \        /  \
2   3      3    2
As we can clearly see, the second tree
is mirror image of the first.
Example 2:

Input:
n = 3, e = 2
A[] = {1, 2, 1, 3}
B[] = {1, 2, 1, 3}
Output:
0
Explanation:
   1          1
 / \        /  \
2   3      2    3
As we can clearly see, the second tree
isn't mirror image of the first.
 */
public class CheckMirrorTree {
    public static void main(String[] args) {
    
    }
    
    static int checkMirrorTree(int n, int e, int[] A, int[] B) {
        HashMap<Integer, ArrayList<Integer>> hash = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> hash1 = new HashMap<>();
        
        for (int i = 0; i < A.length; i += 2) {
            ArrayList<Integer> h;
            if (hash.containsKey(A[i])) {
                h = hash.get(i);
            }
            else {
                h = new ArrayList<>();
            }
            h.add(A[i + 1]);
            hash.put(A[i], h);
            
            if (hash1.containsKey(B[i])) {
                h = hash1.get(i);
            }
            else {
                h = new ArrayList<>();
            }
            h.add(B[i + 1]);
            hash1.put(B[i], h);
        }
        
        for (int i : hash.keySet()) {
            int s = hash.get(i).size();
            if (hash1.containsKey(i) &&
                    s == hash1.get(i).size()) {
                for (int k = 0; k < s; k++) {
                    if (!Objects.equals(hash.get(i).get(k), hash1.get(i).get(s - k - 1))) return 0;
                }
            }
            else {
                return 0;
            }
        }
        return 1;
    }
}
