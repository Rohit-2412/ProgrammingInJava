package DSA.Binary_Search_Tree;

public class CheckBST {
    public static void main(String[] args) {
        int[] arr;
        arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 12,15};
        Node root = Node.create(arr);
//        System.out.println(isBST(root));
        Node.printBinaryTree(root);
    }
    
    static boolean isBST(Node root) {
        return validBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    static boolean validBST(Node root, Long min, Long max) {
        if (root == null) return true;
        
        if (root.data >= max && root.data <= min) {
            return false;
        }
        
        return validBST(root.left, min, (long) root.data) && validBST(root.right, (long) root.data, max);
    }
}
