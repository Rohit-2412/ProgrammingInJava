package DSA.Binary_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RightView {
    
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Node.printBinaryTree(Node.create(a));
        System.out.println(rightView(Node.create(a)));
    }
    
    static ArrayList<Integer> rightView(Node node) {
        if (node == null) return new ArrayList<>();
        
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        
        while (!q.isEmpty()) {
            int n = q.size();
            ans.add(q.peek().data);
            
            for (int i = 1; i <= n; i++) {
                Node curr = q.poll();
                if (curr.right != null) {
                    q.add(curr.right);
                }
                
                if (curr.left != null) {
                    q.add(curr.left);
                }
            }
        }
        return ans;
    }
}
