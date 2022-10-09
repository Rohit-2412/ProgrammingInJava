package Questions;

import java.util.Scanner;

// public class
public class LabProgram {
    
    // main function
    public static void main(String[] args) {
        // creating Scanner class object for user input
        Scanner scnr = new Scanner(System.in);
        // variable to store size of linked list and value to be inserted in linked list
        int size;
        int value;
        // storing size of linked list
        size = scnr.nextInt();
        // storing value to be inserted in the list
        value = scnr.nextInt();
        IntNode headNode = new IntNode(value); // Make head node as the first node
        IntNode lastNode = headNode; // node to add after
        IntNode newnode = null; // node to create
        
        // insert second and the rest of the nodes
        for (int n = 0; n < size - 1; ++n) {
            // storing value
            value = scnr.nextInt();
            // creating new node
            newnode = new IntNode(value);
            // inseting node after the last node
            lastNode.insertAfter(newnode);
            // making newnode as last node now
            lastNode = newnode;
        }
        // calling printlinkedlist to printing linked list using recursive function
        printlinkedList(headNode);
        
    }
    
    // implementation of method to print linked list
    private static void printlinkedList(IntNode head) {
        // if head is null then return from the function
        if (head == null) {
        }
        // otherwise
        else {
            System.out.print(head.data + ", ");
            printlinkedList(head.next);
        }
        
    }
    
    // implementation of IntNode class
    static class IntNode {
        // data members
        int data;
        IntNode next;
        
        // parametrized constructor
        public IntNode(int value) {
            // assigning values
            this.data = value;
            this.next = null;
        }
        
        // default constructor
        public IntNode() {
            this.data = 0;
            this.next = null;
        }
        
        // function to insert node at the end of the list
        public void insertAfter(IntNode node) {
            this.next = node;
        }
    }
}
