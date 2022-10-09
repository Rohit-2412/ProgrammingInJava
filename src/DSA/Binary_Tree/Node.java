package DSA.Binary_Tree;

import java.util.LinkedList;

import static java.lang.System.out;

public class Node {
    int data;
    Node left, right;
    
    Node() {
        data = -1;
        left = right = null;
    }
    
    Node(int item) {
        data = item;
        left = right = null;
    }
    
    public static void preorder(Node root) {
        if (root == null) return;
        
        out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    
    public static void inorder(Node root) {
        if (root == null) return;
        
        inorder(root.left);
        out.print(root.data + " ");
        inorder(root.right);
    }
    
    public static void postorder(Node root) {
        if (root == null) return;
        
        postorder(root.left);
        postorder(root.right);
        out.print(root.data + " ");
    }
    
    public static Node insertLevelOrder(int[] arr, Node root, int i) {
        // Base case for recursion
        if (i < arr.length) {
            root = new Node(arr[i]);
            
            // insert left child
            root.left = insertLevelOrder(arr, root.left, 2 * i + 1);
            
            // insert right child
            root.right = insertLevelOrder(arr, root.right, 2 * i + 2);
        }
        return root;
    }
    
    public static Node create(int[] arr) {
        Node ans = new Node();
        return insertLevelOrder(arr, insertLevelOrder(arr, ans, 0), 0);
    }
    
    public static void printBinaryTree(Node root) {
        LinkedList<Node> treeLevel = new LinkedList<>();
        treeLevel.add(root);
        LinkedList<Node> temp = new LinkedList<>();
        int counter = 0;
        int height = heightOfTree(root) - 1;
        //System.out.println(height);
        double numberOfElements = (Math.pow(2, (height + 1)) - 1);
        //System.out.println(numberOfElements);
        while (counter <= height) {
            Node removed = treeLevel.removeFirst();
            if (temp.isEmpty()) {
                printSpace(numberOfElements / Math.pow(2, counter + 1), removed);
            }
            else {
                printSpace(numberOfElements / Math.pow(2, counter), removed);
            }
            if (removed == null) {
                temp.add(null);
                temp.add(null);
            }
            else {
                temp.add(removed.left);
                temp.add(removed.right);
            }
            
            if (treeLevel.isEmpty()) {
                System.out.println();
                System.out.println();
                treeLevel = temp;
                temp = new LinkedList<>();
                counter++;
            }
            
        }
    }
    
    public static void printSpace(double n, Node removed) {
        for (; n > 0; n--) {
            System.out.print("   ");
        }
        if (removed == null) {
            System.out.print(" ");
        }
        else {
            System.out.print(removed.data);
        }
    }
    
    public static int heightOfTree(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));
    }
    
    @Override
    public String toString() {
        return "Node->data :: " + data;
    }
}