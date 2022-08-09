package Questions;

public class Text {
    public static void main(String[] args) {
        System.out.println("abc" + 1 + 2);
    }
}
/*
PART - 2
1. The four main principles of OOP are: encapsulation, B1, B2, and B3.
 B1 = polymorphism
 B2 = abstraction
 B3 = inheritance

2. The primitive types in Java are int, B4, long, byte, B5 , float, double, and boolean.
B4 = char
B5 = short

3. Usually, we define the main function as follows:
B6 void main(String[] args) ...
B6 = public static

4. B7 polymorphism (a.k.a. method overriding) occurs during the runtime of the
program, where the methods share the same name but have different
implementation.
B7 = Run-time

5. B8 is an engine that provides a runtime environment to drive the Java Code or applications.
B8 = Java Virtual Machine aka JVM

6. All methods of an interface are automatically B9.
B9 = abstract

7. A B10 has the same name as the class.
B10 = Constructor

PART - 3
1. An inner class object cannot access the members of the outer class object that created it,including private
members.()
TRUE
     
2. Overloads can be distinguished by their return type.()
FALSE
Explanation- we cannot distinguish the overloaded functions based on their return type alone we need to check how
many arguments are passed in the function along with their data types.

3.A class can only extend a single class,so a class can only implement a single interface.()
FALSE
Explanation- we can extend a single class, but we can implement more than one interfaces.

4. All classes in Java language contain toString()method.()
TRUE


5. When calling a method with variable parameters,only multiple parameters can be passed in,not arrays.()
TRUE


6. Interface method is abstract method in essence,and interface is a special form of abstract class.()
TRUE


7. HashSet is an unordered collection that rejects duplicates.()
TRUE


8. The answer to the"System.out.println("abc"+1+2);"is"abc3".(
FALSE
Output:: abc12

9. Map stores key-value pairs,which cannot contain duplicate values.()
TRUE


10. There must be a main method for each Java class.()
TRUE

 */