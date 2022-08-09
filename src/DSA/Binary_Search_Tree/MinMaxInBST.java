package DSA.Binary_Search_Tree;

public class MinMaxInBST {
    public static void main(String[] args) {
        int[] arr;
        arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 12};
        Node root = Node.create(arr);
        System.out.println(minValue(root));
        System.out.println(maxValue(root));
    }
    
    static int minValue(Node node) {
        if (node == null) {
            return -1;
        }
        
        while (node.left != null) {
            node = node.left;
        }
        
        return node.data;
    }
    
    static int maxValue(Node node) {
        if (node == null) {
            return -1;
        }
        
        while (node.right != null) {
            node = node.right;
        }
        
        return node.data;
    }
}
