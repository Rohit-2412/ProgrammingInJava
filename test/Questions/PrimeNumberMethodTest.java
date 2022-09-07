package Questions;

import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertTrue;

class PrimeNumberMethodTest {
    
    @Test
    void isPrime1() {
        int number = 5;
        boolean answer = PrimeNumberMethod.isPrime(number);
        boolean correct_answer = true;
        String error = String.format("Test isPrime failed for %d. Returned %s but correct is %s", number, answer,
                correct_answer);
        
        assertTrue(error, answer == correct_answer);
    }
    
    @Test
    void isPrime2() {
        int number = 10;
        boolean answer = PrimeNumberMethod.isPrime(number);
        boolean correct_answer = false;
        String error = String.format("Test isPrime failed for %d. Returned %s but correct is %s", number, answer,
                correct_answer);
        
        assertTrue(error, answer == correct_answer);
    }
    
    
    @Test
    void isPrime3() {
        int number = 83;
        boolean answer = PrimeNumberMethod.isPrime(number);
        boolean correct_answer = true;
        String error = String.format("Test isPrime failed for %d. Returned %s but correct is %s", number, answer,
                correct_answer);
        
        assertTrue(error, answer == correct_answer);
    }
    
    
    @Test
    void isPrime4() {
        int number = 101;
        boolean answer = PrimeNumberMethod.isPrime(number);
        boolean correct_answer = true;
        String error = String.format("Test isPrime failed for %d. Returned %s but correct is %s", number, answer,
                correct_answer);
        
        assertTrue(error, answer == correct_answer);
    }
    
    
    @Test
    void isPrime5() {
        int number = 1000;
        boolean answer = PrimeNumberMethod.isPrime(number);
        boolean correct_answer = false;
        String error = String.format("Test isPrime failed for %d. Returned %s but correct is %s", number, answer,
                correct_answer);
        
        assertTrue(error, answer == correct_answer);
    }
    
    @Test
    void isPrime6() {
        int number = 123123;
        boolean answer = PrimeNumberMethod.isPrime(number);
        boolean correct_answer = false;
        String error = String.format("Test isPrime failed for %d. Returned %s but correct is %s", number, answer,
                correct_answer);
        
        assertTrue(error, answer == correct_answer);
    }
    
    
    @Test
    void isPrime7() {
        int number = 123456;
        boolean answer = PrimeNumberMethod.isPrime(number);
        boolean correct_answer = false;
        String error = String.format("Test isPrime failed for %d. Returned %s but correct is %s", number, answer,
                correct_answer);
        
        assertTrue(error, answer == correct_answer);
    }
}