package DSA.Binary_Tree;

import Utility.FillArray;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ZigzagTraversal {
    public static void main(String[] args) {
        
        int[] a = FillArray.fill(25);
        Node.printBinaryTree(Node.create(a));
        System.out.println(zigZagTraversal(Node.create(a)));
    }
    
    static ArrayList<Integer> zigZagTraversal(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        boolean lToR = true;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            
            // array store current level
            int[] arr = new int[q.size()];
            
            // processing current level
            for (int i = 0; i < q.size(); i++) {
                // popping node
                Node front = q.poll();
                
                // getting index
                int index = lToR ? i : q.size() - i - 1;
                arr[index] = front.data;
                
                // if left exist adding it to queue
                if (front.left != null) q.add(front.left);
                
                // if right exist adding it to queue
                if (front.right != null) q.add(front.right);
            }
            
            // changing direction
            lToR = !lToR;
            
            // adding to answer list
            for (int i : arr)
                ans.add(i);
        }
        
        return ans;
    }
}
