package DSA.Binary_Search_Tree;

public class IntervalTree {
    
    static Interval newNode(int l, int h) {
        return new Interval(l, h);
    }
    
    static IT_Node newNode(Interval i) {
        return new IT_Node(i);
    }
    
    static IT_Node insert(IT_Node root, Interval interval) {
        if (root == null) {
            return newNode(interval);
        }
        
        int l = root.interval.low;
        
        if (interval.low < l) {
            root.left = insert(root.left, interval);
        }
        
        else {
            root.right = insert(root.right, interval);
        }
        
        if (root.max < interval.high) {
            root.max = interval.high;
        }
        
        return root;
    }
    
    static boolean isOverlap(Interval a, Interval b) {
        return a.low < b.high && b.low < a.high;
    }
    
    static Interval overlapSearch(IT_Node root, Interval interval) {
        
        if (root == null) {
            return null;
        }
        
        if (isOverlap(root.interval, interval)) {
            return root.interval;
        }
        
        if (root.left != null && root.left.max >= interval.low) {
            return overlapSearch(root.left, interval);
        }
        return overlapSearch(root.right, interval);
    }
    
    static void print(Interval[] appointment, int n) {
        IT_Node root;
        root = insert(null, appointment[0]);
        
        for (int i = 1; i < n; i++) {
            Interval result = overlapSearch(root, appointment[i]);
            
            if (result != null) {
                System.out.printf("[%d, %d] conflicts with [%d, %d]\n", appointment[i].low, appointment[i].high,
                        result.low, result.high);
            }
            root = insert(root, appointment[i]);
        }
        
    }
    
    public static void main(String[] args) {
        Interval[] appointments = new Interval[6];
        appointments[0] = newNode(1, 5);
        appointments[1] = newNode(3, 7);
        appointments[2] = newNode(2, 6);
        appointments[3] = newNode(10, 15);
        appointments[4] = newNode(5, 6);
        appointments[5] = newNode(4, 100);
        
        int n = appointments.length;
        System.out.print("Following are conflicting intervals\n");
        
        print(appointments, n);
    }
    
    static class Interval {
        int low, high;
        
        public Interval(int low, int high) {
            this.low = low;
            this.high = high;
        }
    }
    
    static class IT_Node {
        Interval interval;
        int max;
        IT_Node left, right;
        
        public IT_Node(Interval interval) {
            this.interval = interval;
            this.max = interval.high;
            this.left = this.right = null;
        }
    }
}
