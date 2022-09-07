package Questions;

// public class
public class PrimeNumberMethod {
    // function to find
    public static boolean isPrime(int number) {
        // looping from 2 till number-1
        // and checks if `number` is divisible by it or not
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                // returning false because number is divisible by some integer except number itself
                return false;
            }
        }
        // returning true as number is not divisible by any of the number from [2, number-1]
        return true;
    }
}