package Questions;

import java.util.Arrays;
import java.util.Scanner;

public class CharacterCruncher {
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println("Welcome to Character Cruncher!");
        System.out.println("Enter a line of text (any characters are allowed).");
        Scanner sc = new Scanner(System.in);
        System.out.print("Your input : ");
        String s = sc.nextLine();
        s = s.toLowerCase();
        char[] arr = s.toCharArray();
        System.out.print("Your data : ");
        System.out.println(arr);
        
        System.out.println("Choose a operation to perform on this text data.");
        System.out.println("1. Display in reverse");
        System.out.println("2. Display in sorted order");
        System.out.println("3. Replace all occurrences of one character with another");
        System.out.println("4. Replace within a range");
        System.out.println("5. Converting it to array of characters");
        System.out.println("6. Displaying array in reverse");
        System.out.println("7. Displaying the array in sorted order");
        System.out.println("8. Reading individual characters");
        System.out.println("9. Replace all");
        System.out.println("10. Replacing all within a range");
        System.out.println("-1 to quit");
        
        System.out.println("Input :");
        int choice = sc.nextInt();
        do {
            switch (choice) {
                case -1:
                    break;
                case 1:
                    reverse(arr);
                    break;
                case 2:
                    sort(arr);
                    break;
                case 3:
                    replaceOccurrences(arr);
                    break;
                case 4:
                    replaceInRange(arr);
                    break;
                case 5:
                    toArray(arr);
                    break;
                case 6:
                    reverseArray(arr);
                    break;
                case 7:
                    sortArray(arr);
                    break;
                case 8:
                    readCharacter(arr);
                    break;
                case 9:
                    replaceAll(arr);
                    break;
                case 10:
                    replaceAllInRange(arr);
                    break;
                default:
                    System.out.print("Array after operation : ");
                    System.out.println(arr);
            }
            System.out.println("Input :");
            choice = sc.nextInt();
        } while (choice != -1);
    }
    
    static void replaceAllInRange(char[] chars) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter new character : ");
        char s = sc.nextLine().charAt(0);
        int st, en;
        System.out.println("Enter starting index");
        st = sc.nextInt();
        System.out.println("Enter ending index");
        en = sc.nextInt();
        char c = sc.next().charAt(0);
        Arrays.fill(chars, st, en, c);
    }
    
    static void replaceAll(char[] chars) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter new character : ");
        char s = sc.nextLine().charAt(0);
        Arrays.fill(chars, s);
    }
    
    static void readCharacter(char[] chars) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter index to read :");
        int idx = sc.nextInt();
        while (idx > chars.length - 1) {
            System.out.println("Invalid index");
            System.out.println("Enter correct index : ");
            idx = sc.nextInt();
        }
        System.out.println(chars[idx]);
    }
    
    static void sortArray(char[] chars) {
        char[] temp = Arrays.copyOf(chars, chars.length);
        Arrays.sort(chars);
        System.out.println(Arrays.toString(chars));
    }
    
    static void reverseArray(char[] chars) {
        StringBuilder sb = new StringBuilder(String.valueOf(chars));
        sb.reverse();
        char[] temp = sb.toString().toCharArray();
        System.out.println(Arrays.toString(temp));
    }
    
    static void toArray(char[] chars) {
        System.out.println(Arrays.toString(chars));
    }
    
    static void replaceInRange(char[] chars) {
        String str = String.valueOf(chars);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter character to replace : ");
        char x = sc.next().charAt(0);
        while (x == ' ') {
            System.out.println("Space can't be replaced\nEnter some other character");
            x = sc.next().charAt(0);
        }
        if (Character.isUpperCase(x)) {
            x = Character.toLowerCase(x);
        }
        System.out.println("Enter new character : ");
        char y = sc.next().charAt(0);
        if (Character.isUpperCase(y)) {
            y = Character.toLowerCase(x);
        }
        System.out.println("Enter start index :");
        int st = sc.nextInt();
        
        System.out.println("Enter end index :");
        int en = sc.nextInt();
        
        
        for (int i = st; i < en; i++) {
            if (str.charAt(i) == 'x') {
                str = str.replace(x, y);
            }
        }
        System.out.println(str);
    }
    
    static void reverse(char[] chars) {
        StringBuilder sb = new StringBuilder(String.valueOf(chars));
        System.out.println(sb.reverse());
    }
    
    static void sort(char[] chars) {
        char[] temp = Arrays.copyOf(chars, chars.length);
        Arrays.sort(temp);
        System.out.println(temp);
    }
    
    static void replaceOccurrences(char[] chars) {
        String str = String.valueOf(chars);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter character to replace : ");
        char x = sc.next().charAt(0);
        while (x == ' ') {
            System.out.println("Space can't be replaced\nEnter some other character");
            x = sc.next().charAt(0);
        }
        if (Character.isUpperCase(x)) {
            x = Character.toLowerCase(x);
        }
        System.out.println("Enter new character : ");
        char y = sc.next().charAt(0);
        if (Character.isUpperCase(y)) {
            y = Character.toLowerCase(x);
        }
        str = str.replace(x, y);
        System.out.println(str);
    }
}