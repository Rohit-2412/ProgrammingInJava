package Questions;

class BinaryTreeNode {
    int info;
    BinaryTreeNode left;
    BinaryTreeNode right;
    
    // constructor
    public BinaryTreeNode(int info) {
        this.info = info;
        this.left = null;
        this.right = null;
    }
    
    //getters
    public int getInfo() {
        return info;
    }
    
    public BinaryTreeNode getLeft() {
        return left;
    }
    
    public BinaryTreeNode getRight() {
        return right;
    }
    
}

class BST {
    int data;
    BST left;
    BST right;
    
    public BST(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    
    public int positiveParents() { return positiveParents(this); }
    
    private int positiveParents(BST root) {
        if (root == null) return 0;
        
        int ans = 0;
        
        if (root.left != null && root.right != null) {
            ans++;
        }
        
        ans += positiveParents(root.left);
        ans += positiveParents(root.right);
        
        return ans;
    }
}

public class Answer4 {
    public static void main(String[] args) {
        BinaryTreeNode treeNode = new BinaryTreeNode(12);
        treeNode.left = new BinaryTreeNode(14);
        treeNode.right = new BinaryTreeNode(10);
        treeNode.right.left = new BinaryTreeNode(1);
        treeNode.right.right = new BinaryTreeNode(5);
        treeNode.right.right.left = new BinaryTreeNode(-7);
        treeNode.right.left.left = new BinaryTreeNode(3);
        treeNode.right.left.left.left = new BinaryTreeNode(-17);
        /*
                    12
               14       10
                     1       5
                  3            -7
                    -17
                  
         */
        
//        tree.setRoot(treeNode);
//        System.out.println(tree.positiveParents());
        
    }
}
