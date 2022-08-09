package DSA.Binary_Search_Tree;

public class Deletion {
    public static void main(String[] args) {
        int[] arr;
        arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 12, 100};
        Node root = Node.create(arr);
        Node.inorder(root);
        System.out.println();
        delete(root, 11);
        Node.inorder(root);
    }
    
    private static Node delete(Node root, int key) {
        if (root == null) {
            return null;
        }
        if (root.data > key) {
            root.left = delete(root.left, key);
        }
        
        else if (root.data < key) {
            root.right = delete(root.right, key);
        }
        
        else {
            if (root.left == null && root.right == null) {
                return null;
            }
            else if (root.left == null) {
                return root.right;
            }
            
            root.data = nextMax(root.right);
            root.right = delete(root.right, root.data);
        }
        return root;
    }
    
    private static int nextMax(Node root) {
        int min = root.data;
        while (root.left != null) {
            min = root.left.data;
            root = root.left;
        }
        return min;
    }
}
