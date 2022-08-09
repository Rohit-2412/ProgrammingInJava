package DSA.Binary_Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateSubtrees {
    
    static Map<String, Integer> m = new HashMap<>();
    static List<Node> v = new ArrayList<>();
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3};
        Node root = Node.create(arr);
        Node.printBinaryTree(root);
        List<Node> l = printAllDups(root);
        for (Node n : l) {
            Node.printBinaryTree(n);
        }
    }
    
    public static List<Node> printAllDups(Node root) {
        v.clear();
        m.clear();
        solve(root);
        return v;
    }
    
    static String solve(Node root) {
        if (root == null) return "";
        
        String left = solve(root.left);
        String right = solve(root.right);
        
        String ans = root.data + "#" + left + "#" + right;
        
        if (m.containsKey(ans)) {
            if (m.get(ans) == 1) {
                v.add(root);
            }
        }
        
        m.put(ans, m.getOrDefault(ans, 0) + 1);
        
        return ans;
    }
    
}
