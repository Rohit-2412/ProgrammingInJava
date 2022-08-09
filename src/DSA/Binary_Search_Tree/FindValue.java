package DSA.Binary_Search_Tree;

public class FindValue {
    public static void main(String[] args) {
//        int[] arr = FillArray.fill(1000000);
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11, 13, 12, 100};
        Node tree = Node.create(arr);
        Node.printBinaryTree(tree);
        
        System.out.println(find(tree, 15));
        System.out.println(find(tree, 11));
        System.out.println(find(tree, 1));
    }
    
    static boolean find(Node root, int val) {
        if (root == null) return false;
        
        if (root.data == val) return true;
        
        if (root.data > val) {
            return find(root.left, val);
        }
        return find(root.right, val);
    }
    
}
