package Questions;

// class implementation
public class Bank {
    // private data field
    private double deposit;
    
    // private data field
    private double interest;
    
    // private data field
    private double timeInYears;
    
    // Default constructor
    public Bank() { }
    
    // parameterized constructor
//    It takes double d, double i and double t as parameters and sets the value of the class data members, using this
//    keyword
// here `this` keyword refers to the object calling this constructor
    public Bank(double d, double i, double t) {
        this.deposit = d; // deposit = d
        this.interest = i; // interest = t
        this.timeInYears = t; // timeInYears = t
    }
    
    //    Declaration and implementation of the function simpleInterest which returns double value by calculating
    //    the simple interest using the formula
    //( P * R * T )/ 10 { P = amount, R = rate , T = time }
    public double simpleInterest() {
        return (this.deposit * this.interest * this.timeInYears) / 100;
    }
    
    //    Declaration and implementation of the function print which prints a message and value of simple interest,
    //    by calling the function
    public void print() {
        // Printing message and value of simple interest
        System.out.println("Simple Interest is:" + this.simpleInterest());
    }
}