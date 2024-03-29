package DSA.String;

/*
Minimum Swaps for Bracket Balancing

You are given a string S of 2N characters consisting of N ‘[‘ brackets and N ‘]’ brackets. A string is considered
balanced if it can be represented in the for S2[S1] where S1 and S2 are balanced strings. We can make an unbalanced
string balanced by swapping adjacent characters. Calculate the minimum number of swaps necessary to make a string
balanced.
Note - Strings S1 and S2 can be empty.



Example 1:

Input  : []][][
Output : 2
Explanation :
First swap: Position 3 and 4
[][]][
Second swap: Position 5 and 6
[][][]
 */
public class BracketBalancing {
    
    public static void main(String[] args) {
        System.out.println(minimumNumberOfSwaps("][][][][][][][][][[[[[[[[]]]][]][[[][]"));
    }
    
    static int minimumNumberOfSwaps(String s) {
        
        int swap = 0;
        int open = 0, close = 0, fault = 0;
        
        for (char c : s.toCharArray()) {
            if (c == ']') {
                close++;
                fault = close - open;
            }
            
            else{
                open++;
                // if we have more closing brackets
                if(fault>0){
                    // then we need to make swaps
                    swap += fault;
                    fault--;
                }
            }
        }
        return swap;
    }
}
