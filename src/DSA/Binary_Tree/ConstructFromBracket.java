package DSA.Binary_Tree;

/*
Construct Binary Tree from String with bracket representation
Difficulty Level : Medium
Last Updated : 04 May 2022
Construct a binary tree from a string consisting of parenthesis and integers. The whole input represents a binary
tree. It contains an integer followed by zero, one or two pairs of parenthesis. The integer represents the root’s
value and a pair of parenthesis contains a child binary tree with the same structure. Always start to construct the
left child node of the parent first if it exists.

Examples:

Input : "1(2)(3)"
Output : 1 2 3
Explanation :
           1
          / \
         2   3
Explanation: first a pair of parenthesis contains
left subtree and second one contains the right
subtree. Preorder of above tree is "1 2 3".

Input : "4(2(3)(1))(6(5))"
Output : 4 2 3 1 6 5
Explanation :
           4
         /   \
        2     6
       / \   /
      3   1 5
 */
public class ConstructFromBracket {
    static int start = 0;
    
    public static void main(String[] args) {
        String s = "4(2(3)(1))(6(5))";
        Node b = constructTree(s);
        Node.printBinaryTree(b);
        Node.preorder(b);
    }
    
    static Node constructTree(String s) {
        if (s.length() == 0) return null;
        
        if (start >= s.length()) {
            return null;
        }
        
        boolean neg = false;
        if (s.charAt(start) == '-') {
            neg = true;
            start++;
        }
        
        int num = 0;
        while (start < s.length() &&
                Character.isDigit(s.charAt(start))) {
            int digit = Character.getNumericValue(s.charAt(start));
            num = num * 10 + digit;
            start++;
        }
        
        if (neg) {
            num *= -1;
        }
        
        Node node = new Node(num);
        
        if (start >= s.length()) {
            return node;
        }
        
        if (start < s.length() && s.charAt(start) == '(') {
            start++;
            node.left = constructTree(s);
        }
        
        if (start < s.length() && s.charAt(start) == ')') {
            start++;
            return node;
        }
        
        if (start < s.length() && s.charAt(start) == '(') {
            start++;
            node.right = constructTree(s);
        }
        if (start < s.length() && s.charAt(start) == ')') {
            start++;
            return node;
        }
        
        return node;
    }
}
