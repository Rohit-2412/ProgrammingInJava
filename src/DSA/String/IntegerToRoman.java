package DSA.String;

import java.util.HashMap;

public class IntegerToRoman {
    
    public static void main(String[] args) {
        System.out.println(intToRoman(95));
    }
    
    static String intToRoman(int n) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"I");
        map.put(4,"IV");
        map.put(5,"V");
        map.put(9,"IX");
        map.put(10,"X");
        map.put(40,"XL");
        map.put(50,"L");
        map.put(90,"XC");
        map.put(100,"C");
        map.put(400,"CD");
        map.put(500,"D");
        map.put(900,"CM");
        map.put(1000,"M");
        
        StringBuilder sb = new StringBuilder();
        int[] number = new int[]
                {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        
        StringBuilder res = new StringBuilder();
        int counter = 0;
        while (n != 0) {
            int rem = n / number[counter];
            if (rem == 0) {
                counter++;
            }
            
            else {
                n = n - number[counter];
                res.append(map.get(number[counter]));
            }
        }
        return res.toString();
    }
    
}
