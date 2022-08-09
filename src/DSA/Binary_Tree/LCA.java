package DSA.Binary_Tree;

import java.util.ArrayList;

public class LCA {
    public static void main(String[] args) {
    
    }
    
    // Recursive way
    static Node lca(Node root, int n1, int n2) {
        
        if (root == null) return null;
        
        if (root.data == n1 || root.data == n2) {
            return root;
        }
        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);
        
        if (left != null && right != null) return root;
        
        if (left != null) {
            return left;
        }
        
        else {
            return right;
        }
    }
    
    // Iterative way
    
    boolean path(Node root, int n, ArrayList<Node> arr) {
        if (root == null) return false;
        arr.add(root);
        if (root.data == n) return true;
        if (path(root.left, n, arr) || path(root.right, n, arr)) {
            
            return true;
        }
        
        arr.remove(arr.size() - 1);
        return false;
    }
    
    Node lcaIterative(Node root, int n1, int n2) {
        ArrayList<Node> arr1 = new ArrayList<>();
        ArrayList<Node> arr2 = new ArrayList<>();
        boolean p1 = path(root, n1, arr1);
        boolean p2 = path(root, n2, arr2);
        if (!p1 || !p2) return null;
        int i;
        for (i = 0; i < arr1.size() && i < arr2.size(); i++) {
            if (arr1.get(i).data != arr2.get(i).data) break;
        }
        return arr1.get(i - 1);
    }
}
