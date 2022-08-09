package Questions;

import java.util.Scanner;

public class Wk6 {
    
    public static void menuOrder() {
        Scanner input = new Scanner(System.in); // create scanner
        int choice;
        
        while (true) {
            
            System.out.println("Drink Menu");
            System.out.println("1. Water");
            System.out.println("2. Tea");
            System.out.println("3. Soda");
            System.out.println("9. Exit Program");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            
            // instances created
            DrinkOrder water = new Water();
            DrinkOrder tea = new Tea();
            DrinkOrder soda = new Soda();
            
            switch (choice) {
                
                case 1:
                    water.drink();
                    break;
                
                case 2:
                    tea.drink();
                    break;
                
                case 3:
                    soda.drink();
                    break;
                
                case 9:
                    System.out.println("Thank you for using using the program. Goodbye!");
                    System.exit(0);
                    break;
                
                default:
                    System.out.println("Invalid! Please select from the menu.");
                    break;
            }
        }
    }
    
    public static void main(String[] args) {
        menuOrder();
    }
    
    public static class DrinkOrder {
        public void drink() {
            System.out.println("Drink");
        }
    }
    
    public static class Water extends DrinkOrder {
        public void drink() {
            System.out.println("Water");
        }
    }
    
    public static class Tea extends DrinkOrder {
        public void drink() {
            System.out.println("Tea");
        }
    }
    
    public static class Soda extends DrinkOrder {
        public void drink() {
            System.out.println("Soda");
        }
    }
}

/*
As we know that in Java execution of program starts from main function, which is a static type function

and a static function can only call other static functions only, it can't call non-static function.

so in order to call the function menuOrder(), the function menuOrder must be static,which it is already.

Now since we're creating instance of Class Water,Tea and Soda then these classes also need to be static so that their
 instances can be created inside a static function.
 
 and if we try to make the function `menuOrder()` non-static then it cannot be called from main function.Hence, we're
 left with only one choice that is to make these classes static.
 */

