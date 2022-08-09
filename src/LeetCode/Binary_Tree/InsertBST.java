package LeetCode.Binary_Tree;

public class InsertBST {
    public static void main(String[] args) {
    
    }
    
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }
        else {
            // when val < root.val
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
