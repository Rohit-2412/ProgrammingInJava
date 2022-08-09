package DSA.Binary_Tree;

/*
Find largest subtree sum in a tree
Difficulty Level : Easy
Last Updated : 28 Jun, 2021
Given a binary tree, task is to find subtree with maximum sum in tree.
Examples:


Input :       1
            /   \
           2      3
          / \    / \
         4   5  6   7
Output : 28
As all the tree elements are positive,
the largest subtree sum is equal to
sum of all tree elements.

Input :       1
            /    \
          -2      3
          / \    /  \
         4   5  -6   2
Output : 7
Subtree with the largest sum is :  -2
                             /  \
                            4    5
Also, entire tree sum is also 7.
 */
public class LargestSubtreeSum {
    public static void main(String[] args) {
        int[] arr = {-1, -2, -4, 5, 6, 7, 6, -1, 0};
        Node.printBinaryTree(Node.create(arr));
        System.out.println(subtreeSum(Node.create(arr)));
        
//        Node root = new Node(1);
//        root.left = new Node(-2);
//        root.right = new Node(3);
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
//        root.right.left = new Node(-6);
//        root.right.right = new Node(2);
//        System.out.println(subtreeSum(root));
    
    }
    
    static int subtreeSum(Node root) {
        int maxValue = Integer.MIN_VALUE;
        return maxSum(root, maxValue);
    }
    
    private static int maxSum(Node root, int maxValue) {
        if (root == null) return 0;
        
        int left = maxSum(root.left, maxValue);
        int right = maxSum(root.right, maxValue);
        
        return Math.max(root.data, Math.max(root.data + left, root.data + right));
    }
    
}
