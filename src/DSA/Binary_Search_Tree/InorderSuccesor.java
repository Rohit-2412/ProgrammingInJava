package DSA.Binary_Search_Tree;

public class InorderSuccesor {
    public static void main(String[] args) {
        Node root = Node.create(new int[] {1, 3, 5, 6, 24, 12, 14, 17, 56, 55});
        Res ans = new Res();
        findPreSuc(root, ans, ans, 15);
        System.out.println(ans.pre.data + " " + ans.succ.data);
    }
    
    static void findPreSuc(Node root, Res p, Res s, int key) {
        if (root == null) {
            return;
        }
        
        Node node = root;
        while (node != null) {
            if (key >= node.data) {
                node = node.right;
            }
            else {
                s.succ = node;
                node = node.left;
            }
        }
        
        node = root;
        while (node != null) {
            if (key <= node.data) {
                node = node.left;
            }
            else {
                p.pre = node;
                node = node.right;
            }
        }
    }
    
    static class Res {
        Node succ, pre;
    }
}
