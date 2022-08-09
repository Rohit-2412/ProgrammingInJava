package DSA.Binary_Search_Tree;

import java.util.ArrayList;

public class MergeBST {
    static ArrayList<Integer> list1 = new ArrayList<>();
    static ArrayList<Integer> list2 = new ArrayList<>();
    static ArrayList<Integer> list3 = new ArrayList<>();
    
    public static void main(String[] args) {
        Node t1 = new Node(10);
        t1.left = new Node(8);
        t1.left.left = new Node(6);
        t1.right = new Node(12);
        t1.right.right = new Node(14);
        
        Node t2 = new Node(100);
        t2.left = new Node(80);
        t2.left.left = new Node(7);
        t2.right = new Node(102);
        t2.right.right = new Node(140);
        
        Node.printBinaryTree(merge(t1, t2));
        System.out.println("List1: " + list1);
        System.out.println("List2: " + list2);
        System.out.println("List3: " + list3);
    }
    
    static Node merge(Node root1, Node root2) {
        storeInorder(root1, list1);
        storeInorder(root2, list2);
        
        mergeAL(list1, list2);
        
        return constructTree(0, list3.size() - 1, list3, null);
    }
    
    private static Node constructTree(int st, int end, ArrayList<Integer> list, Node root) {
        
        if (st > end) return null;
        
        int mid = (end + st) / 2;
        
        if (root == null) root = new Node(list.get(mid));
        root.left = constructTree(st, mid - 1, list, root.left);
        root.right = constructTree(mid + 1, end, list, root.right);
        
        return root;
    }
    
    private static void mergeAL(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        int m = list1.size();
        int n = list2.size();
        
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (list1.get(i) < list2.get(j)) {
                list3.add(list1.get(i++));
            }
            
            // if (list1.get(i) > list2.get(j))
            else {
                list3.add(list2.get(j++));
            }
        }
        
        while (i < m) {
            list3.add(list1.get(i++));
        }
        while (j < n) {
            list3.add(list2.get(j++));
        }
    }
    
    private static void storeInorder(Node root, ArrayList<Integer> list) {
        if (root == null) return;
        
        storeInorder(root.left, list);
        list.add(root.data);
        storeInorder(root.right, list);
    }
}
