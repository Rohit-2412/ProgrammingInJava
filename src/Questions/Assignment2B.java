package Questions;

import java.util.Scanner;

// public class
public class Assignment2B {
    // main function
    public static void main(String[] args) {
        System.out.println("[Lerping!]");
        // creating an object of Scanner class for input from user
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the X coordinate for Keyframe #1: ");
        int keyframe1 = scanner.nextInt(); // storing keyframe1 input
        
        System.out.print("Enter the X coordinate for Keyframe #2: ");
        int keyframe2 = scanner.nextInt();  // storing keyframe1 input
        
        System.out.print("How many frames have passed? ");
        int framesPassed = scanner.nextInt(); // storing frames input
        
        int totalDistance = keyframe2 - keyframe1; // calculating total distance
        
        System.out.println("The character has to move " + totalDistance + " places in a second.");
        
        double currentX30 = keyframe1 + (totalDistance * (framesPassed / 30.0)); // calculating position of x at rate
        // of 30 fps
        double currentX60 = keyframe1 + (totalDistance * (framesPassed / 60.0)); // calculating position of x at rate
        // of 60 fps
        
        // if rate's value is giving modulus with 1 as 0 => implies that the value is a whole number
        // displaying the double value in integer format by type-casting
        if (currentX30 % 1 == 0) {
            System.out.println("At 30 FPS, their current X position would be " + (int) currentX30);
        }
        // otherwise displaying double value
        else {
            System.out.printf("At 60 FPS, their current X position would be %.4f\n", currentX30);
        }
        
        // if rate's value is giving modulus with 1 as 0 => implies that the value is a whole number
        // displaying the double value in integer format by type-casting
        if (currentX60 % 1 == 0) {
            System.out.println("At 60 FPS, their current X position would be " + (int) currentX60);
        }
        // otherwise displaying double value
        else {
            System.out.printf("At 60 FPS, their current X position would be %.4f\n", currentX60);
        }
        
        // END OF PROGRAM
    }
}