package DSA.Binary_Tree;

import java.util.*;

public class ReverseLevelTraversal {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        List<Integer> l = revLevelOrder(Node.create(arr));
        List<Integer> l = reverseLevelOrder(Node.create(arr));
        System.out.println(l);
    }
    
    static ArrayList<Integer> revLevelOrder(Node node) {
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
        
        Collections.reverse(res);
        return res;
    }

    static ArrayList<Integer> reverseLevelOrder(Node node) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        q.add(node);

        while (!q.isEmpty()) {
            Node temp = q.remove();
            stack.add(temp.data);
            
            if (temp.right != null) q.add(temp.right);

            if (temp.left != null) q.add(temp.left);
        }

        while (!stack.isEmpty()) {
            ans.add(stack.pop());
        }

        return ans;
    }
    
}
