package Questions;

import java.util.Scanner;

// public class
class CTest {
    
    //   main function
    public static void main(String[] args) {
//        Scanner class object to read data from user
        Scanner stdin = new Scanner(System.in);

//        declaring variables to store input entered by the user and initializing them with 0
        int callsReceived = 0;
        int operatorsOnCall = 0;
        int numCallsPerOperator;

//        Scanner class object to read data from user
        Scanner sc = new Scanner(System.in);

//        try catch block to handle any exceptions/errors occurred
        try {
//            printing message on screen to enter input
            System.out.print("Enter the number of calls received: ");
            callsReceived = sc.nextInt(); // storing the input using Scanner class object
            
        } catch (Exception e) // catch block to handle exceptions
        {
//            displaying error message on screen
            System.out.println("INVALID");
//            storing buffer input left un-handled by sc.nextInt()
            sc.next();
        }
        
        try {
//            printing message on screen to enter input
            System.out.print("Enter the number of operators on a call: ");
            operatorsOnCall = sc.nextInt(); // storing the input using Scanner class object

//          if operators on call is 0 throwing exception because this is wrong
            if (operatorsOnCall == 0) throw new Exception();
        } catch (Exception e) // catch block to handle exceptions
        {
//            displaying error message on screen
            System.out.println("INVALID");
//            storing buffer input left un-handled by sc.nextInt()
            sc.next();
        }

//        try catch block to calculate number of calls per operator
        try {
            numCallsPerOperator = callsReceived / operatorsOnCall;

//            displaying answer calculated
//            in JAVA we use `+` to add / concatenate two strings while printing to screen
            System.out.println("Number of calls received per operator is: (" + numCallsPerOperator + ").");
        } catch (Exception e) {
//            if any error occurred while calculating answer then displaying this message
            System.out.println("Error occurred due to INVALID INPUTS");
        }
        
    }
    
}