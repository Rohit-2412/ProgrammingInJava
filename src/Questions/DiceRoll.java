package Questions; /* remove this line while submitting code*/

import java.util.Random;
import java.util.Scanner;

// public class
public class DiceRoll {
    // main function
    public static void main(String[] args) {
        // creating Scanner class object to take user input
        Scanner scnr = new Scanner(System.in);
        // creating an object of Random class for random number
        Random randGen = new Random();
        int seedVal; // variable to store seed value
        seedVal = scnr.nextInt(); // storing seed value in a variable
        randGen.setSeed(seedVal); // setting seed value in random number generator
        
        // printing a random number within range [0,9] using nextInt on random class object
        System.out.println(randGen.nextInt(10));
        // printing a random number within range [0,9] using nextInt on random class object
        System.out.println(randGen.nextInt(10));
    }
}
