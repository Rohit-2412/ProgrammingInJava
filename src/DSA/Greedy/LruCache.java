// 05-08-2022 20:20 August

package DSA.Greedy;

import java.util.HashMap;

public class LruCache {
    public static void main(String[] args) {
        
    }
    
    static class LRUCache {
        int cap;
        Node head = new Node(0, 0);
        Node tail = new Node(0, 0);
        HashMap<Integer, Node> map;
        
        LRUCache(int cap) {
            this.cap = cap;
            map = new HashMap<>();
            head.next = tail;
            tail.prev = head;
        }
        
        private void insert(Node node) {
            map.put(node.key, node);
            Node head_next = head.next;
            head.next = node;
            node.prev = head;
            node.next = head_next;
            head_next.prev = node;
        }
        
        private void remove(Node node) {
            map.remove(node.key);
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
        
        public int get(int key) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                remove(node);
                insert(node);
                return node.value;
            }
            else {
                return -1;
            }
        }
        
        public void set(int key, int value) {
            if (map.containsKey(key)) {
                remove(map.get(key));
            }
            
            if (cap == map.size()) {
                remove(tail.prev);
            }
            
            insert(new Node(key, value));
        }
        
        static class Node {
            Node next, prev;
            int key, value;
            
            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }
}
