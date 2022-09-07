// 07-09-2022 20:16 September

package Questions;

public class PrimeNumberMethod {
    public static boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    
}
