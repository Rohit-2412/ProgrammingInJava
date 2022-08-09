package DSA.Binary_Search_Tree;

import java.util.ArrayList;

public class ConvertBstToBalancedBst {
    static ArrayList<Integer> in;
    
    public static void main(String[] args) {
        Node root = new Node(100);
        root.left = new Node(90);
        root.left.left = new Node(80);
        root.left.left.left = new Node(70);
        root.left.left.left.left = new Node(60);
        root.left.left.left.left.left = new Node(50);
        
        Node.inorder(root);
        System.out.println();
        System.out.println();
        
        Node.printBinaryTree(balanceBST(root));
    }
    
    static Node balanceBST(Node root) {
        in = new ArrayList<>();
        setIn(root);
        return createTree(in.stream().mapToInt(i -> i).toArray(), 0, in.size()-1, null);
    }
    
    static void setIn(Node root) {
        if (root == null) return;
        
        setIn(root.left);
        in.add(root.data);
        setIn(root.right);
    }
    
    static Node createTree(int[] arr, int start, int end, Node root) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        
        if (root == null) {
            root = new Node(arr[mid]);
        }
        
        root.left = createTree(arr, start, mid - 1, root.left);
        root.right = createTree(arr, mid + 1, end, root.right);
        
        return root;
    }
}
