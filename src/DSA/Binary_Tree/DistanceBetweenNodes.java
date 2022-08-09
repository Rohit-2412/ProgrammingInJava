package DSA.Binary_Tree;

/*
Min distance between two given nodes of a Binary Tree
Medium Accuracy: 45.05% Submissions: 59771 Points: 4
Given a binary tree and two node values your task is to find the minimum distance between them.

Example 1:

Input:
        1
      /  \
     2    3
a = 2, b = 3
Output: 2
Explanation: The tree formed is:
       1
     /   \
    2     3
We need the distance between 2 and 3.
Being at node 2, we need to take two
steps ahead in order to reach node 3.
The path followed will be:
2 -> 1 -> 3. Hence, the result is 2.
 */
public class DistanceBetweenNodes {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15};
        Node root = Node.create(arr);
        Node.printBinaryTree(root);
        System.out.println(findDist(root, 12, 15));
    }
    
    static int findDist(Node root, int a, int b) {
        Node lca = LCA(root, a, b);
        
        int aDist = distFromNode(lca, a, 0);
        int bDist = distFromNode(lca, b, 0);
        
        return aDist + bDist;
    }
    
    static Node LCA(Node root, int a, int b) {
        if (root == null) return null;
        
        if (root.data == a || root.data == b) {
            return root;
        }
        
        Node l = LCA(root.left, a, b);
        Node r = LCA(root.right, a, b);
        
        if (l != null && r != null) return root;
        
        return l != null ? l : r;
    }
    
    static int distFromNode(Node root, int value, int distance) {
        if (root == null) return -1;
        
        if (root.data == value) return distance;
        
        int leftDist = distFromNode(root.left, value, distance + 1);
        if (leftDist != -1) return leftDist;
        
        return distFromNode(root.right, value, distance + 1);
    }
}
