package DSA.Binary_Search_Tree;

public class KthSmallestinBST {
    
    public static void main(String[] args) {
        Node root = Node.create(new int[] {6, 7, 8, 10, 12, 14, 80, 100, 102, 140});
        kthLargest(root, 5, new Count());
        kthLargest(root, 1, new Count());
        kthLargest(root, 3, new Count());
        kthLargest(root, 4, new Count());
    }
    
    static void kthLargest(Node root, int k, Count count) {
        if (root == null || count.c >= k) {
            return;
        }
        
        kthLargest(root.left, k, count);
        
        count.c++;
        
        if (count.c == k) {
            System.out.println(k + "th smallest element is " + root.data);
            return;
        }
        
        kthLargest(root.right, k, count);
    }
}