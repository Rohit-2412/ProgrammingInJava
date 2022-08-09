package DSA.String;

public class NumberOfCustomer {
    public static void main(String[] args) {
        System.out.println(customer(1, "ABCBCA"));
    }
    
    static int customer(int n, String s) {
        int res = 0;
        int occupied = 0;
        /*
        seen[0] = customer is visited first time
        seen[1] =  he is in queue, didn't get a computer
        seen[2] =  he got a computer and using it 
         */
        int[] seen = new int[26];
        
        for (char c : s.toCharArray()) {
            int idx = c - 'A';
            
            if (seen[idx] == 0) {
                seen[idx] = 1; // customer visited
                // if we have enough computers to serve then allot one
                if (occupied < n) {
                    // he is using the computer now
                    occupied++;
                    seen[idx] = 2;
                }
                else {
                    res++;
                }
            }
            else if (seen[idx] == 2) {
                seen[idx] = 0;
                occupied--;
            }
            
        }
        return res;
    }
}
