package Questions;
// required imports

import java.util.Arrays;
import java.util.Scanner;

public class Lab4 {
    //    main method
    public static void main(String[] args) {
//        declaring an object of Scanner class to take input
        Scanner scanner = new Scanner(System.in);
//        printing message to enter number of elements in array
        System.out.println("How many elements in the array?");
//        storing the input in `size`
        int size = scanner.nextInt();

//        declaring a double array of size = 'size'
        double[] array = new double[size];
//        initializing the sum as 0
        double sumOfArray = 0.0;

//        running for loop from 0 to size-1
        for (int i = 0; i < size; i++) {
//            printing message to enter value
            System.out.println("Please enter the next value:");
//            storing the value in array[i]
            array[i] = scanner.nextDouble();
//            adding current value to the total sum
            sumOfArray = sumOfArray + array[i];
        }
//        sorting the array in ascending order
        Arrays.sort(array);
//        initializing count with 0
        int count = 0;
//        running reverse for loop from size-1 to 0
        for (int i = size - 1; i >= 0; i--) {
//            incrementing count by one
            count++;
//            printing the element with a space " "
            System.out.print(array[i] + " ");
//            if count is a multiple of 7 {because n % 7 == 0 implies remainder 0 when divided by 7}
//            printing a new line character
            if (count % 7 == 0) System.out.println();
        }
//        printing a new line to add some space
        System.out.println();
//        printing the total sum with an appropriate message
        System.out.println("The sum of the array's elements is: " + sumOfArray);
    }
}
