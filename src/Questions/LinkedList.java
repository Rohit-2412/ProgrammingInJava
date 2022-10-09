package Questions;

public class LinkedList {
    
    /**
     * main function
     */
    public static void main(String[] args) {
        // creating linked list
        int[] arr = {6, 8, 5, 5, 4, 1, 4, 6};
        // creating headNode of linked list
        IntNode head = new IntNode(arr[0]);
        // iterating through array and adding elements to linked list
        for (int i = 1; i < arr.length; i++) {
            insertAtEnd(head, arr[i]);
        }
        // displaying linked list
        display(head);
        
        // storing head of sorted linked list
        IntNode list2 = listSort(head);
        // displaying sorted linked list
        display(list2);
    }
    
    public static void insertAtEnd(IntNode head, int i) {
        // creating new node
        IntNode newNode = new IntNode(i);
        // creating temp node
        IntNode temp = head;
        // iterating through linked list
        while (temp.link != null) {
            temp = temp.link;
        }
        // adding new node to linked list
        temp.link = newNode;
    }
    
    // utility function to display linked list
    public static void display(IntNode head) {
        // creating temporary node
        IntNode temp = head;
        
        // checking if linked list is empty
        if ((temp == null) || (temp.link == null)) {
            System.out.println("List is empty");
            return;
        }
        
        // iterating through linked list
        while (temp != null) {
            // printing data of node
            System.out.print(temp.data + "->");
            temp = temp.link;
        }
        System.out.println("null");
    }
    
    // function to sort linked list using selection sort algorithm
    public static IntNode listSort(IntNode head) {
        // creating a temporary node for storing head of linked list
        IntNode list2 = new IntNode(-1);
        // getting length of linked list
        int length = getLength(head);
        
        for (int i = 0; i < length; i++) {
            // getting maximum element from linked list
            int maxNode = getMaxNode(head);
            // storing new head of linked list
            head = deleteNode(head, maxNode);
            // inserting maximum element at the start of sorted linked list
            insertAtBeg(list2, maxNode);
        }
        
        // returning head of sorted linked list
        return list2.link;
    }
    
    // utility function to get length of linked list
    static int getLength(IntNode head) {
        IntNode temp = head; // creating temporary node
        int count = 0; // initializing count variable to 0
        // iterating through linked list
        while (temp != null) {
            count++;
            temp = temp.link;
        }
        // returning length of linked list
        return count;
    }
    
    // function to add node at the beginning of linked list
    public static void insertAtBeg(IntNode headNode, int data) {
        // making a new node with data
        IntNode newNode = new IntNode(data);
        // changing link of new node to head node
        newNode.link = headNode.link;
        headNode.link = newNode;
    }
    
    // function to delete node from linked list
    public static IntNode deleteNode(IntNode headNode, int data) {
        // creating temporary node
        IntNode temp = headNode;
        
        // checking if node to be deleted is head node
        if (headNode.data == data) {
            // changing head node to next node
            headNode = headNode.link;
            // returning head node
            return headNode;
        }
        
        // iterating through linked list
        while (temp.link != null) {
            // checking if data of next node is equal to data to be deleted
            if (temp.link.data == data) {
                // changing link of current node to next node
                temp.link = temp.link.link;
                break;
            }
            // shifting temporary node to next node
            temp = temp.link;
        }
        // returning head node
        return headNode;
    }
    
    // utility function to get maximum element from linked list
    public static int getMaxNode(IntNode headNode) {
        // creating temporary node
        IntNode temp = headNode;
        // initializing maximum element to head node
        int maxValue = temp.data;
        
        // iterating through linked list
        while (temp.link != null) {
            // checking if data of next node is greater than maximum element
            if (temp.link.data > maxValue) {
                // changing maximum element to data of next node
                maxValue = temp.link.data;
            }
            // shifting temporary node to next node
            temp = temp.link;
        }
        // returning maximum element
        return maxValue;
    }
}

/**
 * Node class for LinkedList
 */
class IntNode {
    
    // data members
    int data;
    IntNode link;
    
    // Parametrized constructor
    IntNode(int data) {
        this.data = data;
        this.link = null;
    }
}
