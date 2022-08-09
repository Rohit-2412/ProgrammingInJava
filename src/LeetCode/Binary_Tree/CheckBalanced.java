package LeetCode.Binary_Tree;

public class CheckBalanced {
    static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        
        if (!isBalanced(root.left)) return false;
        
        if (!isBalanced(root.right)) return false;
        
        int lh = height(root.left);
        int rh = height(root.right);
        
        return Math.abs(lh - rh) <= 1;
    }
    
    static int height(TreeNode node) {
        if (node == null) return 0;
        
        int lHeight = height(node.left);
        int rHeight = height(node.right);
        
        return 1 + Math.max(lHeight, rHeight);
    }
}
