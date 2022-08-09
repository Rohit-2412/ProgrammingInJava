package DSA.Binary_Search_Tree;

public class MedianOfBST {
    public static void main(String[] args) {
        Node root = Node.create(new int[] {1, 2, 3, 4, 5, 6, 7});
        System.out.println(median(root));
    }
    
    static int median(Node root) {
        if (root == null) return 0;
        
        int count = countNodes(root);
        int currCount = 0;
        Node currentNode = root, pre = null, prev = null;
        
        while (currentNode != null) {
            if (currentNode.left == null) {
                currCount++;
                
                if (count % 2 != 0 && currCount == (count + 1) / 2) {
                    return prev.data;
                }
                else if (count % 2 == 0 && currCount == count / 2) {
                    return (prev.data + currentNode.data) / 2;
                }
                
                prev = currentNode;
                currentNode = currentNode.right;
            }
            
            else {
                pre = currentNode.left;
                while (pre.right != null && pre.right != currentNode) {
                    pre = pre.right;
                }
                
                if (pre.right == null) {
                    pre.right = currentNode;
                    currentNode = currentNode.left;
                }
                else {
                    pre.right = null;
                    prev = pre;
                    
                    currCount++;
                    
                    if (count % 2 != 0 && currCount == (count + 1) / 2) {
                        return prev.data;
                    }
                    else if (count % 2 == 0 && currCount == count / 2) {
                        return (prev.data + currentNode.data) / 2;
                    }
                    
                    prev = currentNode;
                    currentNode = currentNode.right;
                    
                }
            }
        }
        return -1;
    }
    
    static int countNodes(Node root) {
        Node current = root, pre;
        int count = 0;
        while (current != null) {
            if (current.left == null) {
                count++;
                current = current.right;
            }
            else {
                pre = current.left;
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                }
                else {
                    pre.right = null;
                    count++;
                    
                    current = current.right;
                }
            }
        }
        return count;
    }
}
