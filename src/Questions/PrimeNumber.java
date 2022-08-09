package Questions;
// Package import for using arraylist list and scanner class

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Public class named as prime number
public class PrimeNumber {
    //        main method()
    public static void main(String[] args) {
//        Declaring a variable `number` to store the number till where we have to find the prime numbers
        int number;
//        Creating an object of scanner class to take input from the user
        Scanner scanner = new Scanner(System.in);
//        Displaying a message to user to enter the number till where we have to print prime number and its sum
        System.out.print("Enter a positive number greater than 1 : ");
//        Storing the input entered by user in the variable `number`
        number = scanner.nextInt();

//        Calling the function `genPrimeNumber()` and printing the list returned by the function
        System.out.println(genPrimeNumber(number));
        
    }
    
    //    Implementation of the function `genPrimeNumber()` to generate a list of prime numbers between 1 and n
    static List<Integer> genPrimeNumber(int num) {
//        Checking if number is negative
        if (num < 0) {
//            If yes then printing a message that prime numbers can't be negative and
            System.out.println("Prime numbers can't be negative");
//            returning an empty arraylist
            return new ArrayList<>();
        }

//        Declaring a variable named as sum to store the sum of all the prime numbers
        long sum = 0;
//        Declaring a list named as listOfPrimeNumber to store the prime numbers between one and 10
        List<Integer> listOfPrimeNumber = new ArrayList<>();

//        Running a for loop from 2 till n
//        Because first prime number is 2
        for (int i = 2; i < num; i++) {
//            Calling the function check prime to check if the current number is a prime number or not
            if (checkPrime(i)) {
//                If the current number is a prime number then, adding this number in our list
                listOfPrimeNumber.add(i);
//                Adding the current number to the sum variable
                sum = sum + i;
            }
        }
//        Displaying a message that: sum of all prime numbers between one and n is equal to `sum` {obtained by adding
//        all the prime numbers}
        System.out.println("Sum of all prime numbers between 1 and " + num + " is " + sum);
//        Returning the generated list of prime number
        return listOfPrimeNumber;
    }
    
    //    Implementation of the function check prime to check if a number is prime number or not
    private static boolean checkPrime(int n) {
//        Running a for loop from 2 till end
//        Because every number is divisible by one{1} that's why we have started our loop from 2
        for (int i = 2; i < n; i++) {
//            Checking if the remainder obtained by dividing the number from 2 till n is 0 or not
            if (n % i == 0) {
//            If it's o then this implies that the current number has a prime factor other than one and itself
//                Returning false as our answer
                return false;
            }
        }
//        If the complete for loop is executed, and we haven't returned false then this means that our current number
//        is a prime number
//        Returning true as our answer
        return true;
    }
}
