package LeetCode.Binary_Tree;

public class Arr2BST {
    public static void main(String[] args) {
    
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        return makeBST(nums, 0, nums.length - 1);
    }
    
    public TreeNode makeBST(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = makeBST(arr, start, mid - 1);
        root.right = makeBST(arr, mid + 1, end);
        return root;
    }
}
