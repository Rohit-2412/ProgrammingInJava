// 08-10-2022 03:25 October

package Questions;

public class Lab6 {
    
    // main function
    public static void main(String[] args) {
        // declaring a string
        String s1 = "welcome to cs 2";
        String s2 = "Hello World in JAVA";
        
        // calling the method to print the string in camelCase
        System.out.println(camelCaseRecursive(s1));
        System.out.println(camelCaseRecursive(s2));
        
        // printing a separator line
        System.out.println("<<---------------------------------------->>");
        
        // declaring an array of string
        String[] arr = {"A", "AA", "BB", "CC", "AAA", "CBC", "CCC"};
        
        // calling the method to search for the string
        System.out.println(lengthBinarySearchIterative(arr, "BB"));
        System.out.println(lengthBinarySearchIterative(arr, "AA"));
        System.out.println(lengthBinarySearchIterative(arr, "AC"));
        System.out.println(lengthBinarySearchIterative(arr, "CCC"));
        
        // printing a separator line
        System.out.println("<<---------------------------------------->>");
        
        // calling the method to search for the string
        System.out.println(lengthBinarySearchRecursive(arr, "BB", 0, arr.length - 1));
        System.out.println(lengthBinarySearchRecursive(arr, "AA", 0, arr.length - 1));
        System.out.println(lengthBinarySearchRecursive(arr, "AC", 0, arr.length - 1));
        System.out.println(lengthBinarySearchRecursive(arr, "CCC", 0, arr.length - 1));
    }
    
    // method to convert the string to camelCase
    public static String camelCaseRecursive(String input) {
        return camelCaseRecursive(input, 0);
    }
    
    // method to convert the string to camelCase using recursion
    public static String camelCaseRecursive(String input, int idx) {
        // base case
        if (idx == input.length()) {
            return "";
        }
        // if the character is a space then skip it and add it as it is
        else if (input.charAt(idx) == ' ') {
            // recursive call
            return input.charAt(idx) + camelCaseRecursive(input, idx + 1);
        }
        // if the index is even then convert the character to lower case
        else if (idx % 2 == 0) {
            return (
                    // converting the character to lower case and adding it to the string then,
                    // recursive call
                    Character.toLowerCase(input.charAt(idx)) + camelCaseRecursive(input, idx + 1));
        }
        // if the index is odd then convert the character to upper case
        else {
            return (
                    // converting the character to upper case and adding it to the string then,
                    // recursive call
                    Character.toUpperCase(input.charAt(idx)) + camelCaseRecursive(input, idx + 1));
        }
    }
    
    // function to search for the string in the array sorted by length
    public static boolean lengthBinarySearchIterative(String[] input, String search) {
        // declaring the variables
        int low = 0;
        int high = input.length - 1;
        
        // looping until the high is greater than or equal to low
        while (high >= low) {
            // calculating the mid
            int mid = (low + high) / 2;
            
            // if the length of the string at mid is greater than the length of the search string
            if (search.length() < input[mid].length()) {
                // shifting the high to mid - 1
                high = mid - 1;
            }
            // if the length of the string at mid is less than the length of the search string
            else if (search.length() > input[mid].length()) {
                // shifting the low to mid + 1
                low = mid + 1;
            }
            // if the length of the string at mid is equal to the length of the search string
            else {
                // if the string at mid is equal to the search string
                if (input[mid].equals(search)) {
                    // return true
                    return true;
                }
                // if the string at mid is greater than the search string
                else if (input[mid].compareTo(search) > 0) {
                    // shifting the high to mid - 1
                    high = mid - 1;
                }
                // if the string at mid is less than the search string
                else {
                    // shifting the low to mid + 1
                    low = mid + 1;
                }
            }
        }
        
        // if the string is not found then return false
        return false;
    }
    
    // function to search for the string in the array sorted by length recursively
    public static boolean lengthBinarySearchRecursive(String[] input, String search, int start, int end) {
        // base case
        if (start > end) {
            return false;
        }
        
        // calculating the mid
        int mid = (start + end) / 2;
        
        // if the length of the string at mid is greater than the length of the search string
        if (search.length() < input[mid].length()) {
            // recursive call with the high to mid - 1
            return lengthBinarySearchRecursive(input, search, start, mid - 1);
        }
        // if the length of the string at mid is less than the length of the search string
        else if (search.length() > input[mid].length()) {
            // recursive call with the low to mid + 1
            return lengthBinarySearchRecursive(input, search, mid + 1, end);
        }
        // if the string at mid is equal to the search string
        else {
            // if the string at mid is equal to the search string
            if (input[mid].equals(search)) {
                // return true
                return true;
            }
            // if the string at mid is greater than the search string
            else if (input[mid].compareTo(search) > 0) {
                // recursive call with the high to mid - 1
                return lengthBinarySearchRecursive(input, search, start, mid - 1);
            }
            // if the string at mid is less than the search string
            else {
                // recursive call with the low to mid + 1
                return lengthBinarySearchRecursive(input, search, mid + 1, end);
            }
        }
    }
}
