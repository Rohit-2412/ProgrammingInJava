package Questions;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestSubstringWithoutRepeating {
    // main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // scanner class object for user input
        System.out.print("Enter number of characters: ");
        int length = sc.nextInt(); // storing number of characters
        
        // declaring a char array of length as number of character for creating linked list
        char[] chars = new char[length];
        
        // looping from 0 till length to store input
        for (int i = 0; i < length; i++) {
            System.out.print("> ");
            chars[i] = sc.next().charAt(0); // storing character in array
        }
        
        LinkedListNode password = LinkedListNode.create(chars); // calling create function defined in class to make
        // linked list from chars array
        
        // displaying answer with message
        System.out.println("The length of strongest password possible is: " + lengthOfLongestSubstring(password));
    }
    
    // function to find the length of the longest substring from the linked list without repeating characters
    static int lengthOfLongestSubstring(LinkedListNode head) {
        
        StringBuilder pass = new StringBuilder(); // creating String builder class object to make string from linked
        // list
        // traversing linked list until head is null
        while (head != null) {
            pass.append(head.data); // adding character to string
            head = head.next; // shifting pointer
        }
        
        Set<Character> set = new HashSet<>(); // declaring a set to store the unique characters appeared in string
        int length = 0;
        int result = 0;
        
        // iterating through string
        for (int idx = 0; idx < pass.length(); idx++) {
            
            // if set has current character already present
            while (set.contains(pass.charAt(idx))) {
                set.remove(pass.charAt(length)); // removing it from set
                length++; // increasing length by one
            }
            // if current character is not present then adding it to set
            set.add(pass.charAt(idx));
            
            // calculating result as Maximum of { result, current character position - length of repeated chars }
            result = Math.max(result, idx + 1 - length);
        }
        
        // returning result
        return result;
    }
    
}

// class Node for linked list
class LinkedListNode {
    
    public LinkedListNode next;
    public char data;
    
    // Default constructor
    LinkedListNode() { }
    
    // Parameterized constructor
    LinkedListNode(char key) {
        data = key;
        next = null;
    }
    
    // utility function to create linked list from array
    public static LinkedListNode create(char[] arr) {
        LinkedListNode node = null;
        
        // using for-each loop on array
        for (char j : arr) {
            // calling insert function for each character in array
            node = insert(node, j);
        }
        
        // returning head node of Linked list
        return node;
    }
    
    // helper function to insert a value in Linked List
    private static LinkedListNode insert(LinkedListNode root, char val) {
        LinkedListNode temp = new LinkedListNode(val); // creating a temp node with val as value
        LinkedListNode ptr = new LinkedListNode(); // new Linked list
        ptr.next = null;
        
        // if root is empty or null
        if (root == null) {
            root = temp; // assigning temp as the Linked list
        }
        
        else {
            ptr = root; // assigning root to ptr
            
            // traversing to end of linked list
            while (ptr.next != null) ptr = ptr.next;
            
            // making next of temp as list node's next node
            ptr.next = temp;
        }
        
        // returning root of linked list
        return root;
    }
}