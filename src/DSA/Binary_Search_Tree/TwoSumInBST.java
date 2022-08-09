package DSA.Binary_Search_Tree;

import java.util.LinkedHashSet;
import java.util.Set;

public class TwoSumInBST {
    static Set<Integer> elements = new LinkedHashSet<>();
    static int c = 0;
    
    public static void main(String[] args) {
    
    }
    
    public static int countPairs(Node root1, Node root2, int x) {
        // Code here
        elements.clear();
        c = 0;
        
        preOrder(root1);
        isExistsCount(root2, x);
        return c;
        
    }
    
    static void preOrder(Node root) {
        if (root == null) return;
        elements.add(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }
    
    static void isExistsCount(Node root, int x) {
        if (root == null) return;
        
        if (elements.contains(x - root.data)) {
            c++;
        }
        isExistsCount(root.left, x);
        isExistsCount(root.right, x);
    }
    
}