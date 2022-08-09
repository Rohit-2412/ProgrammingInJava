package LeetCode.Binary_Search_Tree;

public class RangeSum {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        
        if (root.val >= low && root.val <= high) {
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        }
        
        else if (root.val > low) {
            return rangeSumBST(root.left, low, high);
        }
        else {
            return rangeSumBST(root.right, low, high);
        }
    }
}
