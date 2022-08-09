package DSA.Binary_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    
    
    public static void main(String[] args) {
        int[] arr = {-1, 2, 3, -4, 5, 6, -7, 8, 9};
        List<Integer> l = levelOrder(Node.create(arr));
        System.out.println(l);
        Node tree = Node.create(arr);
        Node.printBinaryTree(tree);
        
    }
    
    static ArrayList<Integer> levelOrder(Node node) {
        
        ArrayList<Integer> res = new ArrayList<>();
        
        Queue<Node> q = new LinkedList<>();
        
        q.offer(node);
        
        while (!q.isEmpty()) {
            Node curr = q.poll();
            
            res.add(curr.data);
            
            if (curr.left != null) {
                q.offer(curr.left);
            }
            
            if (curr.right != null) {
                q.offer(curr.right);
            }
        }
        
        return res;
    }
    
//    static int positiveParents(Node root) {
//        if (root == null) return 0;
//
//        int ans = 0;
//        if (root.left != null && root.right != null && root.data > 0) {
//            ans++;
//        }
//        ans += positiveParents(root.left);
//        ans += positiveParents(root.right);
//        return ans;
//    }
    
    
}
