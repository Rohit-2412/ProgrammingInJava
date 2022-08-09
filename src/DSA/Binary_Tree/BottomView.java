package DSA.Binary_Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.TreeMap;

public class BottomView {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Node.printBinaryTree(Node.create(a));
        System.out.println(bottomView(Node.create(a)));
    }
    
    private static ArrayList<Integer> bottomView(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 0));
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        Pair temp = null;
        Node node = null;
        
        while (!q.isEmpty()) {
            int s = q.size();
            
            for (int i = 0; i < s; i++) {
                temp = q.poll();
                node = temp.node;
                
                map.put(temp.height, node.data);
                
                if (node.left != null) {
                    q.add(new Pair(node.left, temp.height - 1));
                }
                
                if (node.right != null) {
                    q.add(new Pair(node.right, temp.height + 1));
                }
            }
        }
        
        return new ArrayList<>(map.values());
    }
    
    static class Pair {
        Node node;
        int height;
        
        Pair() { }
        
        public Pair(Node node, int state) {
            this.node = node;
            this.height = state;
        }
    }
}
