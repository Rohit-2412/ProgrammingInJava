package DSA.Binary_Tree;

public class CheckBalanced {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(isBalanced(Node.create(a)));
    }
    
    static boolean isBalanced(Node root) {
        if (root == null) return true;
        
        if (!isBalanced(root.left)) return false;
        
        if (!isBalanced(root.right)) return false;
        
        int lh = height(root.left);
        int rh = height(root.right);
        
        return Math.abs(lh - rh) <= 1;
    }
    
    static int height(Node node) {
        if (node == null) return 0;
        
        int lHeight = height(node.left);
        int rHeight = height(node.right);
        
        return 1 + Math.max(lHeight, rHeight);
    }
    
}
