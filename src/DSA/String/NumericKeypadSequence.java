package DSA.String;

/*
For each character, store the sequence which should be obtained at its respective position in an array, i.e. for Z,
store 9999. For Y, store 999. For K, store 55 and so on.
For each character, subtract ASCII value of ‘A’ and obtain the position in the array pointed
by that character and add the sequence stored in that array to a string.
If the character is a space, store 0
Print the overall sequence.
 */

public class NumericKeypadSequence {
    
    static String[] str = {"2", "22", "222",
                           "3", "33", "333",
                           "4", "44", "444",
                           "5", "55", "555",
                           "6", "66", "666",
                           "7", "77", "777", "7777",
                           "8", "88", "888",
                           "9", "99", "999", "9999"
    };
    
    public static void main(String[] args) {
        generateSequences("JAVA");
    }
    
    static void generateSequences(String s) {
        
        StringBuilder sb = new StringBuilder();
        
        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                sb.append(0);
            }
            else {
                sb.append(str[ch - 'A']);
            }
            
        }
        System.out.println(sb);
        
    }
}
