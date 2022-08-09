// 05-07-2022 19:27 July

/*
Given a string S of distinct character of size N and their corresponding frequency f[ ] i.e. character S[i] has f[i]
frequency. Your task is to build the Huffman tree print all the huffman codes in preorder traversal of the tree.
Note: While merging if two nodes have the same value, then the node which occurs at first will be taken on the left
of Binary Tree and the other one to the right, otherwise Node with less value will be taken on the left of the
subtree and other one to the right.

Example 1:

S = "abcdef"
f[] = {5, 9, 12, 13, 16, 45}
Output:
0 100 101 1100 1101 111
 */

package DSA.Greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HuffmanCoding {
    
    
    public static void main(String[] args) {
        String s = "abcdef";
        int[] f = new int[] {5, 9, 12, 13, 16, 45};
        System.out.println(huffmanCodes(s, f, f.length));
    }
    
    static ArrayList<String> result = new ArrayList<>();
    
    static ArrayList<String> huffmanCodes(String s, int[] freq, int n) {
        PriorityQueue<Code> heap =
                new PriorityQueue<>(Comparator.comparingInt(o -> o.frequency));
        
        
        for (int i = 0; i < n; i++) {
            Code x = new Code(s.charAt(i), freq[i]);
            heap.add(x);
        }
        
        while (heap.size() > 1) {
            Code root = new Code();
            Code left = heap.poll();
            Code right = heap.poll();
            
            root = root.newCode('*', left.frequency + right.frequency);
            
            if (left.frequency <= right.frequency) {
                root.left = left;
                root.right = right;
            }
            else {
                root.left = right;
                root.right = left;
            }
            
            heap.add(root);
        }
        
        Code root = heap.peek();
        preorder(root, "");
        return result;
    }
    
    private static void preorder(Code root, String s) {
        if (root.left == null && root.right == null) {
            result.add(s);
            return;
        }
        
        preorder(root.left, s + '0');
        preorder(root.right, s + '1');
        
    }
    
}

class Code {
    char data;
    int frequency;
    Code left, right;
    
    public Code() {
        left = null;
        right = null;
    }
    
    public Code(char data, int frequency) {
        this.data = data;
        this.frequency = frequency;
        left = null;
        right = null;
    }
    
    Code newCode(char data, int frequency) {
        Code temp = new Code(data, frequency);
        temp.left = null;
        temp.right = null;
        return temp;
    }
    
    @Override
    public String toString() {
        return "<%c, %d>".formatted(data, frequency);
    }
}
