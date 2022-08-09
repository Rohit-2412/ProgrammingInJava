package DSA.Binary_Tree;

public class Height {
    public static void main(String[] args) {
        int []a = {1,2,3,4,5,6,7,8,9,10};
        Node l = Node.create(a);
        System.out.println(height(l));
    }
    
    static int height(Node node) {
        if (node == null) return 0;
        
        int lHeight = height(node.left);
        int rHeight = height(node.right);
        
        return 1 + Math.max(lHeight, rHeight);
    }
}
