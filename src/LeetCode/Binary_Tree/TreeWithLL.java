package LeetCode.Binary_Tree;

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    
    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }
    
    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class TreeWithLL {
    public static void main(String[] args) {
    
    }
    
    public Node connect(Node root) {
        if (root == null || root.left == null || root.right == null) return root;
        // if we have a left and right node then connect them from the root
        root.left.next = root.right;
    
        if (root.next != null) {
            root.right.next = root.next.left;
        }
        // recursive calls
        connect(root.left);
        connect(root.right);
        return root;
    }
}
