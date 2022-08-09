package Questions;

import java.util.Scanner;

public class LabProgram {
    /* main function */
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in); /* instantiating an object of Scanner class for user input */
        String userText; /* declaring a variable to store string(one line) entered by user */
        int length = 0; /* declaring variable to store the length of characters excluding { '.' , ',' , ' ' } */
        
        /* declaring variables for these characters */
        char space = ' '; // space
        char period = '.'; // period
        char comma = ','; // comma
        char exclamation = '!'; // exclamation
        
        userText = scnr.nextLine(); /* storing the input entered by user including spaces */
        
        /* iterating over each character of userText */
        for (char currentChar : userText.toCharArray()) {
            /* if the current character is not equal to anyone of the three characters then we can increment the
            length */
            if (currentChar != space && currentChar != period && currentChar != comma && currentChar != exclamation) {
                length++;
            }
        }
        /* printing the total length */
        System.out.println(length);
    }
}
