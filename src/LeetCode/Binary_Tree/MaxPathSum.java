package LeetCode.Binary_Tree;


public class MaxPathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(-6);
        root.right.right = new TreeNode(2);
        System.out.println(maxPathSum(root));
    }
    
    public static int maxPathSum(TreeNode root) {
        int maxValue = Integer.MIN_VALUE;
        return maxPath(root, maxValue);
    }
    
    public static int maxPath(TreeNode root, int maxVal) {
        if (root == null) {
            return 0;
        }
        int left = maxPath(root.left, maxVal);
        int right = maxPath(root.right, maxVal);
        int nodeMax = Math.max(Math.max(root.val, root.val + left + right), Math.max(root.val + left,
                root.val + right));
        return Math.max(root.val, Math.max(root.val + left, root.val + right));
//        int leftSum = Math.max(0, maxPath(root.left, maxVal));
//        int rightSum = Math.max(0, maxPath(root.right, maxVal));
//        maxVal = Math.max(maxVal, leftSum + rightSum + root.val);
//        return Math.max(leftSum , rightSum) + root.val;
    }
}
