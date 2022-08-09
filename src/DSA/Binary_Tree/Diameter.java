package DSA.Binary_Tree;

import Utility.FillArray;

public class Diameter {
    // Method 1
    
    static int dia;
    
    public static void main(String[] args) {
        int []a = FillArray.fill(16);
        Node b = Node.create(a);
        System.out.println(diameter(b));
    }
    
    static int helper(Node node) {
        if (node == null) return 0;
        
        int lH = helper(node.left);
        int rH = helper(node.right);
        
        dia = Math.max(dia, 1 + rH + lH);
        
        return 1 + Math.max(lH, rH);
    }
    
    static int diameter(Node node) {
        dia = 0;
        helper(node);
        return dia;
    }
}
