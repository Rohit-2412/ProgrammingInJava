package LeetCode.Binary_Tree;

public class MaxDepth {
    public static void main(String[] args) {
    
    }
    
    public static int maxDepth(TreeNode root) {
        // base case
        if (root == null) return 0;
        
        // calling for left and right subtree
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
