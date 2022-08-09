package DSA.String;

/*
Given a string S consisting of only opening and closing curly brackets '{' and '}', find out the minimum number of
reversals required to convert the string into a balanced expression.
A reversal means changing '{' to '}' or vice-versa.
 */

import java.util.Stack;

public class CountReversal {
    
    public static void main(String[] args) {
        System.out.println(countRev("}{{}}{"));
    }
    
    static int countRev(String s) {
        
        Stack<Character> st = new Stack<>();
        int count = 0;
        for (char ch : s.toCharArray()) {
            // if we encounter open bracket then add it to stack
            if (ch == '{') {
                st.add(ch);
            }
            
            // if we encounter closing bracket then two cases occurs :
            else {
                // if stack is empty then we can add it to stack and increment count by one
                if (st.isEmpty()) {
                    st.add(ch);
                    count++;
                }
                
                // if we already some content in the stack and we encountered closing bracket then we can form one
                // pair so popping out one opening bracket
                else {
                    st.pop();
                }
            }
        }
        
        System.out.println(st);
        
        // now if we have even no. of brackets in stack then we will add half the count of stack size
        // because changing one bracket can make one pair
        if ((st.size() & 1) == 0) {
            count += st.size() / 2;
            return count;
        }
        // if we have odd number of elements then we can't make it valid
        // so -1
        else {
            return -1;
        }
        
    }
}
