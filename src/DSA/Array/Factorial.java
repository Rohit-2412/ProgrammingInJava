package DSA.Array;

import java.util.ArrayList;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(4501));
    }
    static ArrayList<Integer> factorial(int N) {
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        java.math.BigInteger F;
        F = java.math.BigInteger.valueOf(1);
        
        for (int i = 2; i <= N; i++) {
            F = F.multiply(java.math.BigInteger.valueOf(i));
        }
        
        // BigInteger to string
        String value = F.toString();
        
        // string to char[]
        char[] charArray = value.toCharArray();
        
        // convert characters to int
        // now it can be added it to list
        for (char c : charArray) {
            int k = Integer.parseInt(String.valueOf(c));
            list.add(k);
        }
        
        return list;
        
    }
    
    
}
