package Concepts.Pattern;

import static java.lang.System.out;

public class Question {
    public static void main(String[] args) {
        pattern1(5);
        out.println();
//        pattern2(5);
    }
    
    public static void pattern1(int n) {
        /*
         *****
         *****
         *****
         *****
         *****
         */
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                out.print("* ");
            }
            out.println();
        }
    }
    
    public static void pattern2(int n) {
        /*
         *
         **
         ***
         ****
         *****
         */
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                out.print("* ");
            }
            out.println();
        }
    }
}
