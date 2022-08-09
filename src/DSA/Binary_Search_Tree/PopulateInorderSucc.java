package DSA.Binary_Search_Tree;

public class PopulateInorderSucc {
    public static void main(String[] args) {
    
    }
    
    Node successor(Node root, int k) {
        Node temp = root;
        Node succ = null;
        while (temp != null) {
            if (temp.data > k) {
                succ = temp;
                temp = temp.left;
            }
            else {
                temp = temp.right;
            }
        }
        
        return succ;
        
    }
    
    void populate(Node root, Node k) {
        if (k == null) {
            return;
        }
        k.next = successor(root, k.data);
        populate(root, k.left);
        populate(root, k.right);
    }
    
    void populateNext(Node root) {
        populate(root, root);
    }
    
    static class Node {
        int data;
        Node left, right, next;
        
        public Node(int data) {
            this.data = data;
        }
    }
}
