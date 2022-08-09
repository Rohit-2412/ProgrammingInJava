package Questions;

import java.util.Scanner;

class Time {
    // Creating a scanner class and making it static so that we can use it in all objects of class "Time"
    static Scanner scanner = new Scanner(System.in);
    // Declaring data members as hour minute and second
    int hour;
    int minute;
    int second;
    
    // Declaring and defining default constructor
    public Time() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }
    
    // Parameterized constructor
    public Time(int hour, int minute, int second) {
        
        // Checking if the value of hour is negative or not
        if (hour < 0) {
            // If it is negative then,
            // we will print a message and,
            // ask the user to enter it again
            System.out.println("Hour can't be negative!");
            System.out.println("Enter again : ");
            this.hour = scanner.nextInt(); // taking user input
            // If it is again negative then,
            // we will ask the user to enter the value again and again
            // until he/she enters a positive value of hour
            while (this.hour < 0) {
                System.out.println("Wrong Input");
                this.hour = scanner.nextInt();
            }
        }
        
        else {
            this.hour = hour;
        }
        
        // Performing the same task for minute also
        if (minute < 0) {
            System.out.println("Minute can't be negative!");
            System.out.println("Enter again : ");
            this.minute = scanner.nextInt();
            while (this.minute < 0) {
                System.out.println("Wrong Input");
                this.minute = scanner.nextInt();
            }
        }
        
        else {
            this.minute = minute;
        }
        
        // Performing the same task for second also
        if (second < 0) {
            System.out.println("Second can't be negative!");
            System.out.println("Enter again : ");
            this.second = scanner.nextInt();
            while (this.second < 0) {
                System.out.println("Wrong Input");
                this.second = scanner.nextInt();
            }
        }
        
        else {
            this.second = second;
        }
        
        // Checking if second value is greater than or equal to 60
        if (this.second >= 60) {
            // If yes then converting the seconds into correct minutes and seconds value
            this.minute = this.minute + this.second / 60;
            this.second = this.second % 60;
        }
        
        // Checking if minute value is greater than or equal to 60
        if (this.minute >= 60) {
            // If yes then converting the Minutes  into correct minutes and hour value
            this.hour = this.hour + this.minute / 60;
            this.minute = this.minute % 60;
        }
    }
    
    public int getHour() {
        return hour;
    }
    
    public void setHour(int hour) {
        if (hour < 0) {
            System.out.println("Hour can't be negative!");
            System.out.println("Enter again : ");
            this.hour = scanner.nextInt();
            while (this.hour < 0) {
                System.out.println("Wrong Input");
                this.hour = scanner.nextInt();
            }
        }
        else {
            this.hour = hour;
        }
    }
    
    public int getMinute() {
        return minute;
    }
    
    public void setMinute(int minute) {
        if (minute < 0) {
            System.out.println("Minute can't be negative!");
            System.out.println("Enter again : ");
            this.minute = scanner.nextInt();
            while (this.minute < 0) {
                System.out.println("Wrong Input");
                this.minute = scanner.nextInt();
            }
        }
        else {
            this.minute = minute;
        }
        
        if (minute >= 60) {
            this.hour = this.hour + this.minute / 60;
            this.minute = this.minute % 60;
        }
    }
    
    public int getSecond() {
        return second;
    }
    
    public void setSecond(int second) {
        if (second < 0) {
            System.out.println("Second can't be negative!");
            System.out.println("Enter again : ");
            this.second = scanner.nextInt();
            while (this.second < 0) {
                System.out.println("Wrong Input");
                this.second = scanner.nextInt();
            }
        }
        else {
            this.second = second;
        }
        
        if (this.second >= 60) {
            this.minute = this.minute + this.second / 60;
            this.second = this.second % 60;
        }
        
    }
    
    // setting hour, minute & second
    public void setTime(int h, int m, int s) {
        this.hour = h;
        this.minute = m;
        this.second = s;
    }
    
    public void print() {
        // String formatting
        System.out.printf("%02d:%02d:%02d", this.hour, this.minute, this.second);
    }
}

public class Answer2 {
    public static void main(String[] args) {
        Time t = new Time(0, 1, 59);
        t.print();
    }
}
