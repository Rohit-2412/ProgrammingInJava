package DSA.Binary_Search_Tree;


import java.util.ArrayList;
import java.util.Collections;

public class BSTfromTree {
    ArrayList<Integer> list = new ArrayList<>();
    int i = 0;
    
    void inOrder(Node node) {
        if (node == null) {
            return;
        }
        
        inOrder(node.left);
        list.add(node.data);
        inOrder(node.right);
    }
    
    void createBST(Node node) {
        if (node == null) {
            return;
        }
        
        createBST(node.left);
        node.data = list.get(i);
        i++;
        createBST(node.right);
    }
    
    Node binaryTreeToBST(Node root) {
        inOrder(root);
        Collections.sort(list);
        createBST(root);
        return root;
    }
}
