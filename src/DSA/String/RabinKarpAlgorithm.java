package DSA.String;

public class RabinKarpAlgorithm {
    
    // d is the number of characters in the input alphabet
    public final static int d = 256;
    
    /* pat -> pattern
        txt -> text
        q -> A prime number
    */
    static void search(String pat, String txt, int q) {
        int M = pat.length();
        int N = txt.length();
        int i, j;
        int hash_p = 0; // hash value for pattern
        int hash_t = 0; // hash value for txt
        int h = 1;
        
        // The value of h would be "pow(d, M-1)%q"
        for (i = 0; i < M - 1; i++)
            h = (h * d) % q;
        
        // Calculate the hash value of pattern and first
        // window of text
        for (i = 0; i < M; i++) {
            hash_p = (d * hash_p + pat.charAt(i)) % q;
            hash_t = (d * hash_t + txt.charAt(i)) % q;
        }
        
        // Slide the pattern over text one by one
        for (i = 0; i <= N - M; i++) {
            
            // Check the hash values of current window of text
            // and pattern. If the hash values match then only
            // check for characters one by one
            if (hash_p == hash_t) {
                /* Check for characters one by one */
                for (j = 0; j < M; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j)) {
                        break;
                    }
                }
                
                // if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]
                if (j == M) {
                    System.out.println("Pattern found at index " + i);
                }
            }
            
            // Calculate hash value for next window of text: Remove
            // leading digit, add trailing digit
            if (i < N - M) {
                hash_t = (d * (hash_t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;
                
                // We might get negative value of t, converting it
                // to positive
                if (hash_t < 0) {
                    hash_t = (hash_t + q);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        String txt = "code java with intellij java";
        String pat = "java";
        
        // A prime number
        int q = 101;
        
        // Function Call
        search(pat, txt, q);
    }
}
