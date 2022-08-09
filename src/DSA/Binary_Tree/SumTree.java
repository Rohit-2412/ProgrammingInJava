package DSA.Binary_Tree;

import Utility.FillArray;

public class SumTree {
    public static void main(String[] args) {
        int[] a = FillArray.fill(7);
        Node tree = Node.create(a);
        Node.printBinaryTree(tree);
        toSumTree(tree);
        Node.printBinaryTree(tree);
    }
    
    public static void toSumTree(Node root) {
        sumNode(root);
    }
    
    private static int sumNode(Node root) {
        if (root == null) return 0;
        
        int leftData = sumNode(root.left);
        int rightData = sumNode(root.right);
        
        int data = root.data;
        
        root.data = leftData + rightData;
        
        return data + leftData + rightData;
    }
}
