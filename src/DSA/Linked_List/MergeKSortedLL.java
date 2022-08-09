package DSA.Linked_List;

public class MergeKSortedLL {
    static Node mergeKList(Node[] arr, int K) {
        // Min heap approach
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//        for (Node head : arr) {
//            while (head != null) {
//                minHeap.add(head.data);
//                head = head.next;
//            }
//        }
//        Node dummy = new Node(-1);
//        Node head = dummy;
//        while (!minHeap.isEmpty()) {
//            head.next = new Node(minHeap.remove());
//            head = head.next;
//        }
//        return dummy.next;
        
        // MergeSort Approach
        for (int i = 0; i < K - 1; i++) {
            // sorting two lists and passing the resultant list on next iteration
            arr[i + 1] = merge(arr[i], arr[i + 1]);
        }
        return arr[K - 1];
    }
    
    static Node merge(Node first, Node second) {
        if (first == null) return second;
        
        if (second == null) return first;
        Node result = null;
        if (first.data > second.data) {
            result = second;
            result.next = merge(first, second.next);
        }
        else {
            result = first;
            result.next = merge(first.next, second);
        }
        
        return result;
    }
}
