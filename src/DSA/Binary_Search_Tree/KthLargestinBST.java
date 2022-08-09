package DSA.Binary_Search_Tree;

class Count {
    int c = 0;
}

public class KthLargestinBST {
    
    public static void main(String[] args) {
        Node root = Node.create(new int[] {6, 7, 8, 10, 12, 14, 80, 100, 102, 140});
        kthLargest(root, 5, new Count());
        kthLargest(root, 1, new Count());
        kthLargest(root, 3, new Count());
        kthLargest(root, 4, new Count());
    }
    
    static void kthLargest(Node root, int k, Count c) {
        if (root == null || c.c >= k) {
            return;
        }
        
        kthLargest(root.right, k, c);
        
        c.c++;
        
        if (c.c == k) {
            System.out.println(k + "th largest element is " + root.data);
            return;
        }
        
        kthLargest(root.left, k, c);
        // Morris traversal
        /*
        Node curr = root;
        Node kLargest = null;
        
        int count = 0;
        
        while (curr != null) {
            
            if (curr.right == null) {
                if (++count == k) {
                    kLargest = curr;
                }
                
                curr = curr.left;
            }
            
            else {
                Node succ = curr.right;
                
                while (succ.left != null && succ.left != curr) {
                    succ = succ.left;
                }
                
                if (succ.left == null) {
                    succ.left = curr;
                    
                    curr = curr.right;
                }
                
                else {
                    succ.left = null;
                    
                    if (++count == k) {
                        kLargest = curr;
                        
                    }
                    curr = curr.left;
                }
            }
        }
        return kLargest.data;*/
        
    }
    
}
