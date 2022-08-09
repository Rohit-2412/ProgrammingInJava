// 09-07-2022 22:44 July

package Questions;

public class TestProgram {
    // main function
    public static void main(String[] args) {
        Base obj = new Base(); // creating an object of Base class
        double[] d1 = new double[] {0.0, 1.1, 2.2, 3.3}; // creating an array d1 of double type with 0.0,1.1,2.2,3.3
        // as its elements
        System.out.println(obj.fun(d1)); // calling fun function of base class
        
        obj = new Circle(); // making obj as an object of Circle class
        double[] d2 = new double[] {10}; // creating an array
        // now obj will invoke the fun of Circle (derived Class) and not of Base class
        System.out.println("Area of Circle: " + obj.fun(d2));
        
        obj = new Triangle();// making obj as an object of Circle class
        double[] d3 = new double[] {7, 8}; // creating an array
        // now obj will invoke the fun of Triangle (derived Class) and not of Base class
        System.out.println("Area of Triangle: " + obj.fun(d3));
        
        obj = new Square();// making obj as an object of Square class
        double[] d4 = new double[] {11}; // creating an array
        // now obj will invoke the fun of Square (derived Class) and not of Base class
        System.out.println("Area of Square: " + obj.fun(d4));
        
        obj = new Ball();// making obj as an object of Ball class
        double[] d5 = new double[] {10}; // creating an array
        // now obj will invoke the fun of Ball (derived Class) and not of Base class
        System.out.println("Area of Ball: " + obj.fun(d5));
        
        obj = new Rectangle();// making obj as an object of Rectangle class
        double[] d6 = new double[] {5, 10}; // creating an array
        // now obj will invoke the fun of Rectangle (derived Class) and not of Base class
        System.out.println("Area of Rectangle: " + obj.fun(d6));
        
        obj = new Maximum();// making obj as an object of Maximum class
        double[] d7 = new double[] {10.0, 45.12, 4.5, 1.23, 85.96, 74.63, 123.321, 1.1, 1.11}; // creating an array
        // now obj will invoke the fun of Maximum (derived Class) and not of Base class
        System.out.println("Maximum element: " + obj.fun(d7));
    }
    
}

// Base class definition
class Base {
    // `fun()` function
    public double fun(double[] d) {
        System.out.println("There are " + d.length + " elements.");
        return 1.0;
    }
}

// Circle class extending Base class (inheriting)
class Circle extends Base {
    public double fun(double[] d) {
        // returning answer
        return Math.PI * d[0] * d[0];
    }
}

// Triangle class extending Base class (inheriting)
class Triangle extends Base {
    public double fun(double[] d) {
        // returning answer
        return 0.5 * d[0] * d[1]; // 0.5 * base * height
    }
}

// Square class extending Base class (inheriting)
class Square extends Base {
    public double fun(double[] d) {
        // returning answer
        return d[0] * d[0]; // side * side
    }
}

// Ball class extending Base class (inheriting)
class Ball extends Base {
    public double fun(double[] d) {
        // returning answer
        return Math.PI * Math.pow(d[0], 2) * 4; // 4 * pi * r^2 (r*r)
    }
}

// Rectangle class extending Base class (inheriting)
class Rectangle extends Base {
    public double fun(double[] d) {
        // returning answer
        return d[0] * d[1]; // length * breadth
    }
}

// Maximum class extending Base class (inheriting)
class Maximum extends Base {
    public double fun(double[] d) {
        double maxElement = Double.MIN_VALUE; // initialising the answer the lowest possible value
        // looping through the array and comparing the answer with each element
        for (double val : d) {
            if (maxElement < val) maxElement = val;
        }
        // returning answer
        return maxElement;
    }
}