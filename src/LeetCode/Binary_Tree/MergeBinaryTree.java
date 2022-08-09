package LeetCode.Binary_Tree;

public class MergeBinaryTree {
    public static void main(String[] args) {
    
    }
    
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        
        int v1 = root1 != null ? root1.val : 0;
        int v2 = root2 != null ? root2.val : 0;
        TreeNode newTree = new TreeNode(v1 + v2);
        newTree.left = mergeTrees(root1 != null ? root1.left : null, root2 != null ? root2.left : null);
        newTree.right = mergeTrees(root1 != null ? root1.right : null, root2 != null ? root2.right : null);
        
        return newTree;
    }
}
