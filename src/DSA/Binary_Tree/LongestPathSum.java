package DSA.Binary_Tree;

/*
Sum of the Longest Bloodline of a Tree (Sum of nodes on the longest path from root to leaf node)
Easy Accuracy: 49.91% Submissions: 26980 Points: 2
Given a binary tree of size N. Your task is to complete the function sumOfLongRootToLeafPath(), that find the sum of
all nodes on the longest path from root to leaf node.
If two or more paths compete for the longest path, then the path having maximum sum of nodes is being considered.

Example 1:

Input:
        4
       / \
      2   5
     / \ / \
    7  1 2  3
      /
     6
Output: 13
Explanation:
        4
       / \
      2   5
     / \ / \
    7  1 2  3
      /
     6

The highlighted nodes (4, 2, 1, 6) above are
part of the longest root to leaf path having
sum = (4 + 2 + 1 + 6) = 13
Example 2:

Input:
          1
        /   \
       2     3
      / \   / \
     4   5 6   7
Output: 11
 */
public class LongestPathSum {
    static int maxLen = 0;
    static int maxSum = Integer.MIN_VALUE;
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 1, 2, 3, 4, 5, 6};
        Node.printBinaryTree(Node.create(arr));
        System.out.println(sumOfLongRootToLeafPath(Node.create(arr)));
    }
    
    static int sumOfLongRootToLeafPath(Node root) {
        if (root == null) return 0;
        
        int len = 0;
        int sum = 0;
        
        solver(root, len, sum);
        
        return maxSum;
    }
    
    static void solver(Node root, int len, int sum) {
        if (root == null) return;
        
        if (root.left == null && root.right == null) {
            sum += root.data;
            
            if (len > maxLen) {
                maxLen = len;
                maxSum = sum;
            }
            return;
        }
        
        sum += root.data;
        
        solver(root.left, len + 1, sum);
        solver(root.right, len + 1, sum);
    }
    
    
}
