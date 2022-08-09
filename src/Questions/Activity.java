package Questions;

public class Activity {
    // main function
    public static void main(String[] args) {
        // creating 3 objects of Rectangle class
        RectangleQuestion r1 = new RectangleQuestion(1, 2, 3, 4);
        RectangleQuestion r2 = new RectangleQuestion(1, 2, 3, 4);
        RectangleQuestion r3 = new RectangleQuestion(10, 12, 13, 45);
        // calling required functions for r1
        System.out.println(r1);
        System.out.println(r1.getArea());
        System.out.println(r1.getPerimeter());
        System.out.println(r1.getDiagonal());
        System.out.println(r1.isEqualTo(r2));
        System.out.println(r1.contains(2, 3));
        
        // calling required functions for r3
        System.out.println(r3);
        System.out.println(r3.getArea());
        System.out.println(r3.getPerimeter());
        System.out.println(r3.getDiagonal());
        System.out.println(r3.isEqualTo(r2));
        System.out.println(r3.contains(2, 3));
    }
}
