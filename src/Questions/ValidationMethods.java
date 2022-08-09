package Questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ValidationMethods {
    public static void main(String[] args) {
//Initialize local variables
        Scanner sIn = new Scanner(System.in); //Input Scanner for String
        int intNum = 0;
        double doubleNum = 0;
        String choice = "";
        String playAgain = "Y";
//Keep program running until user wants to quit
        do {
//Get an integer from the user
            int[] intRange1 = {};
            intNum = getValidInt(sIn, "Please enter a whole number: ", "Invalid response. Only whole numbers are " +
                    "acceptable", intRange1);
            System.out.println("The whole number your entered was: " + intNum);
            System.out.println("Now we will test your whole number in a math equation...");
            System.out.printf("Adding 10 to your whole number would be: 10 + %d = % d.\n\n", intNum, (intNum + 10));
//Get an integer within a range from the user
            int[] intRange2 = {10, 50};
            intNum = getValidInt(sIn, "Please enter a whole number between 10 and 50:", "Invalid response. Only " +
                    "whole numbers between 10 and 50 are acceptable. ", intRange2);
            System.out.println("The whole number your entered was: " + intNum);
            System.out.println("Now we will test your whole number in a math equation...");
            System.out.printf("Adding 10 to your whole number would be: 10 + %d = % d.\n\n", intNum, (intNum + 10));
//Get a Double from the user
            double[] doubleRange1 = {};
            doubleNum = getValidDouble(sIn, "Please enter a floating-point number:", "Invalid response. Only " +
                    "floating-point numbers are acceptable. ", doubleRange1);
            System.out.println("The float your entered was: " + doubleNum);
            System.out.println("Now we will test your floating-point number in a math equation...");
            System.out.printf("Adding 10 to your float would be: 10 + %f = %f.\n\n", doubleNum, (doubleNum + 10));
//Get a Double within a range from the user
            double[] doubleRange2 = {5.5, 10.75};
            doubleNum = getValidDouble(sIn, "Please enter a floating-point number between 5.5 and 10.75:", "Invalid " +
                    "response. Only floating -point numbers between 5.5 and 10.75 are acceptable.", doubleRange2);
            System.out.println("The float your entered was: " + doubleNum);
            System.out.println("Now we will test your floating-point number in a math equation...");
            
            System.out.printf("Adding 10 to your float would be: 10 + %f = %f.\n\n", doubleNum, (doubleNum + 10));

//Get either an "a", "b" or "c" from the user
            String[] options1 = {"a", "b", "c"};
            choice = getValidString(sIn, "Please enter 'a', 'b' or 'c': ",
                    "Invalid response. Only the letters 'a', 'b' or 'c' are acceptable.", options1);
            System.out.printf("The letter your entered was: %s\n\n", choice);
//Get a word from the user
            String[] options2 = {"Chocolate", "Vanilla", "Strawberry"};
            choice = getValidString(sIn, "Please choose either Chocolate, Vanilla or Strawberry:", "Invalid response" +
                    ". Only 'Chocolate', 'Vanilla' and 'Strawberry' are acceptable answers. ", options2);
            System.out.printf("You chose: %s\n\n", choice);
//Get a 'Y' or 'N' from the user
            String[] options3 = {"Y", "y", "N", "n"};
            playAgain = getValidString(sIn, "Would you like to play again? (Y/N): ", "Invalid response. Please " +
                    "answer with a 'Y' or 'N' ", options3);
        } while (playAgain.equalsIgnoreCase("Y"));
        
    }//end of method main()
    
    /**
     * getValidInt method validates user input is an Integer within range and
     * returns it back to the calling method.
     * Uses sIn to get user input from the console.
     * Asks user question.
     * If range is empty, range is ignored and only validates input is an
     * integer.
     * If range is not empty, validates user input is an integer within range.
     * If user input is not valid, prints warning and repeats question.
     * Returns validated input.
     */
    public static int getValidInt(Scanner sIn, String question, String warning,
            int[] range) {
        System.out.print(question); // Printing the question to the screen
        String temp = sIn.next();// Taking input by the user as a string

//Running an infinite while loop
        while (true) {
//            Using the try catch block to check the validity of the input by the user
            try {
//                Converting the input by the user to double using the parseDouble function
                double val = Double.parseDouble(temp);
//                Converting the resultant double value into a integer value
                int valInInteger = (int) val;
//                If the length of range array is 0 or the length array is empty
                if (range.length == 0) {
//                    Returning the input by the user because we have no limits to check
                    return valInInteger;
                }
//                Checking if the inputted value is an integer or not by using the ceil() function this function
//                returns the next greatest integer value
//                Also checking if the integer value lies between the range array's value
                else if (Math.ceil(val) / val == 1 && range[0] <= valInInteger && range[1] >= valInInteger) {
                    return valInInteger;
                }
//                If none of the above two conditions are satisfied then throwing an exception
                else {
                    throw new Exception();
                }
            }
//            Catching the exception thrown by the try block
            catch (Exception e) {
//                Printing a warning to the screen
                System.out.println(warning);
//                Printing the question so that user can enter input again
                System.out.print(question);
//                Storing the value inputted by the user in temp variable
                temp = sIn.next();
            }
        }
    }//end of method getValidInt(Scanner, String, String, int[])
    
    /**
     * getValidDouble method validates user input is a double within range and
     * returns it back to the calling method.
     * Uses sIn to get user input from the console.
     * Asks user question.
     * If range is empty, range is ignored and only validates input is an double.
     * If range is not empty, validates user input is a double within range.
     * If user input is not valid, prints warning and repeats question.
     * Returns validated input.
     */
    public static double getValidDouble(Scanner sIn, String question, String
            warning, double[] range) {
        System.out.print(question); // printing  question to the console screen
        String temp = sIn.next(); // taking value inputted by the user as a string

//        Running and in finite while loop
        while (true) {
//            Using the try catch block to perform our operation
            try {
//                Parsing the value inputted by the user to double
//                If the value is not a valid double value then this will throw an exception which will be handled by
//                the catch block written below
                double val = Double.parseDouble(temp);

//                If range array is empty or its length is equal to 0
                if (range.length == 0) {
                    return val; // Returning value entered by the user because we have no limits to check
                    
                }
//                Checking if the entered value lies between the range provided in the range array
                else if (range[0] <= val && range[1] >= val) {
//                    If it is true then returning the value
                    return val;
                }
//                If none of the above conditions are satisfied then throwing an exception
                else {
                    throw new Exception();
                }
            } catch (Exception e) {
//                Printing warning on the screen
                System.out.println(warning);
//                Printing the question again on the screen
                System.out.print(question);
//                Taking input by the user and storing it in variable temp
                temp = sIn.next();
            }
        }
    }//end of method getValidDouble(Scanner, String, String, double[])
    
    /**
     * getValidString method validates user input is within list of choices and
     * returns it back to the calling method.
     * Uses sIn to get user input from the console.
     * <p>
     * Asks user question.
     * If choices is empty, returns input.
     * If choices is not empty, validates user input is within choices.
     * If user input is not valid, prints warning and repeats question.
     * Returns validated input.
     */
    public static String getValidString(Scanner sIn, String question, String
            warning, String[] choices) {
//        Printing question on the screen
        System.out.print(question);
//        Taking input by the user and storing it in a string variable `answer`
        String answer = sIn.next();
//        Initializing an arrayList from the choices array
        ArrayList<String> choicesList = new ArrayList<>(List.of(choices));

//        Checking if the length of choices list is 0, or it is empty
        if (choicesList.isEmpty()) {
//            If it is empty then we have no choices to check from so returning the answer entered by the user
            return answer;
        }
//        If the choices list is not empty then
        else {
//            Running a while loop until the input entered by the user lies in the list
            while (!choicesList.contains(answer)) {
//                Printing a warning on the screen
                System.out.println(warning);
//                Printing question on the screen
                System.out.print(question);
//                Storing the input entered by the user
                answer = sIn.next();
            }
        }
//        Returning the answer entered by the user
        return answer;
    }
    // end of method getValidString(Scanner, String, String, String[])
}
//end of class Lab9iStartCode