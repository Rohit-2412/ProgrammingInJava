package LeetCode.Binary_Tree;

public class ValidBST {
    public static void main(String[] args) {
    
    }
    
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }
    
    public boolean validate(TreeNode root, Integer max, Integer min) {
        if (root == null) {
            return true;
        }
        else if (max != null && max <= root.val || min != null && min >= root.val) {
            return false;
        }
        else {
            return validate(root.left, root.val, min) && validate(root.right, max, root.val);
        }
    }
}
