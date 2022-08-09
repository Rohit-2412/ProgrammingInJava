// 08-07-2022 10:19 July

package Questions;

class A {
    int value;
    String str;
    
    // default constructor
    A() {
        System.out.println("Default constructor being called");
        value = -1;
        str = null;
    }
    
    // parameterized constructor with 1 int argument
    A(int number) {
        System.out.println("Parameterized constructor with 1 integer argument being called");
        value = number;
        str = null;
    }
    
    // parameterized constructor with 1 String argument
    A(String s) {
        System.out.println("Parameterized constructor with 1 string argument being called");
        value = -1;
        str = s;
    }
    
    // parameterized constructor with 2 arguments
    A(int val, String s) {
        System.out.println("Parameterized constructor with 2 arguments being called");
        value = val;
        str = s;
    }
    
}

public class ConstructorProgram {
    public static void main(String[] args) {
        A a1 = new A(); // default constructor
        A a2 = new A(100); // parameterized constructor
        A a3 = new A("Java"); // parameterized constructor
        A a4 = new A(12345, "Hello World"); // parameterized constructor
    }
}
