package DSA.Searching_Sorting;

/*
Given three distinct numbers A, B and C. Find the number with value in middle (Try to do it with minimum comparisons)
 */
public class MiddleOfThree {
    public static void main(String[] args) {
        System.out.println(middle(978, 518, 300));
    }
    
    static int middle(int num1, int num2, int num3) {
        
        long a = num1;
        long b = num2;
        long c = num3;
        if ((a - b) * (a - c) <= 0) {
            return (int) a;
        }
        
        else if ((b - a) * (b - c) <= 0) {
            return (int) b;
        }
        else {
            return (int) c;
        }
    }
}
