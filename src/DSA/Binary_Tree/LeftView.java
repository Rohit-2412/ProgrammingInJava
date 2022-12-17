package DSA.Binary_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftView {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Node.printBinaryTree(Node.create(a));
        System.out.println(leftView(Node.create(a)));
        List<Integer> list = new ArrayList<>();
        leftViewRecursive(Node.create(a), 0, list);
        System.out.println(list);
    }
    
    static void leftViewRecursive(Node root, int level, List<Integer> ans) {
        if (root == null) {
            return;
        }
        if (ans.size() == level) ans.add(root.data);
        
        leftViewRecursive(root.left, level + 1, ans);
        leftViewRecursive(root.right, level + 1, ans);
    }
    
    static ArrayList<Integer> leftView(Node node) {
        if (node == null) return new ArrayList<>();
        
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        
        while (!q.isEmpty()) {
            int n = q.size();
            ans.add(q.peek().data);
            
            for (int i = 1; i <= n; i++) {
                Node curr = q.poll();
                if (curr.left != null) {
                    q.add(curr.left);
                }
                
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
        return ans;
    }
}
