package DSA.Binary_Tree;

import Utility.FillArray;

public class Diameter {
    // Method 1
    
    static int dia;
    
    public static void main(String[] args) {
        int[] a = FillArray.fill(16);
        Node b = Node.create(a);
        System.out.println(diameter(b));
    }
    
    static int helper(Node root) {
        if (root == null) return 0;
        
        int lH = helper(root.left);
        int rH = helper(root.right);
        
        dia = Math.max(dia, 1 + rH + lH);
        
        return 1 + Math.max(lH, rH);
    }
    
    static int diameter(Node root) {
        /* Approach 1 */
//        dia = 0;
//        helper(root);
//        return dia;
        
        // approach 2
        return fastDiameter(root)[0];
    }
    
    // [dia, height]
    static int[] fastDiameter(Node root) {
        if (root == null) return new int[] {0, 0};
        
        int[] left = fastDiameter(root.left);
        int[] right = fastDiameter(root.right);
        
        // height of left subtree
        int op1 = left[0];
        // height of right subtree
        int op2 = right[0];
        // left height + right height + 1
        int op3 = left[1] + right[1] + 1;
        
        int[] ans = new int[2];
        // max diameter = max of all three combination
        ans[0] = Math.max(op1, Math.max(op2, op3));
        // max height = max of left, right + 1
        ans[1] = Math.max(left[1], right[1]) + 1;
        
        return ans;
    }
}
