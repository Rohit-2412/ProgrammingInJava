package LeetCode.Binary_Tree;

public class InvertBt {
    public static void main(String[] args) {
    
    }
    
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // swapping left and right subtree
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        invertTree(root.left);
        invertTree(root.right);
        
        return root;
    }
}
