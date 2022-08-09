package DSA.Binary_Search_Tree;

public class ConstrcutBSTfromInorder {
    static Node node;
    
    public static void main(String[] args) {
        int[] preorder = {10, 5, 1, 7, 40, 50};
        for (int i : preorder) {
            createBST(i);
        }
        Node.inorder(node);
    }
    
    private static void createBST(int data) {
        node = createNode(node, data);
    }
    
    private static Node createNode(Node node, int data) {
        if (node == null) {
            node = new Node(data);
        }
        
        if (node.data > data) {
            node.left = createNode(node.left, data);
        }
        
        if (node.data < data) {
            node.right = createNode(node.right, data);
        }
        
        return node;
    }
    
}
