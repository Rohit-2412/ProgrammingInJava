package Questions;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertTrue;

public class TestClass {
    @Test
    public void test_00_averageOfOdd() {
        final int[] A = {12, 4, 6};
        double avg = ArrayUtility.averageOfOdd(A);
        double exp = 0.0;
        
        String error = String.format(
                "\n Test averageOfOdd failed for %s. Returned ( %.2f ) " + " but correct is ( %.2f ). \n",
                Arrays.toString(A), avg, exp);
        
        final double THRESHOLD = .01;
        assertTrue(error, Math.abs(exp - avg) < THRESHOLD);
    }
    
    @Test
    public void test_01_averageOfOdd() {
        final int[] A = {3, 6};
        double avg = ArrayUtility.averageOfOdd(A);
        double exp = 3.0;
        
        String error = String.format(
                "\n Test averageOfOdd failed for %s. Returned ( %.2f ) " + " but correct is ( %.2f ). \n",
                Arrays.toString(A), avg, exp);
        
        final double THRESHOLD = .01;
        assertTrue(error, Math.abs(exp - avg) < THRESHOLD);
    }
    
    @Test
    public void test_02_averageOfOdd() {
        final int[] A = {12, 4, 6, 3, 3, 5, 7};
        double avg = ArrayUtility.averageOfOdd(A);
        double exp = 4.5;
        
        String error = String.format(
                "\n Test averageOfOdd failed for %s. Returned ( %.2f ) " + " but correct is ( %.2f ). \n",
                Arrays.toString(A), avg, exp);
        
        final double THRESHOLD = .01;
        assertTrue(error, Math.abs(exp - avg) < THRESHOLD);
    }
    
    @Test
    public void test_03_averageOfOdd() {
        final int[] A = {12, 4, 6, 4, 4, 4, 4, 4, 4, 4, 4, 1};
        double avg = ArrayUtility.averageOfOdd(A);
        double exp = 1.0;
        
        String error = String.format(
                "\n Test averageOfOdd failed for %s. Returned ( %.2f ) " + " but correct is ( %.2f ). \n",
                Arrays.toString(A), avg, exp);
        
        final double THRESHOLD = .01;
        assertTrue(error, Math.abs(exp - avg) < THRESHOLD);
    }
    
    @Test
    public void test_04_averageOfOdd() {
        final int[] A = {12, 4, 6, 4, 4, 4, 4, 4, 4, 4, 4};
        double avg = ArrayUtility.averageOfOdd(A);
        double exp = 0.0;
        
        String error = String.format(
                "\n Test averageOfOdd failed for %s. Returned ( %.2f ) " + " but correct is ( %.2f ). \n",
                Arrays.toString(A), avg, exp);
        
        final double THRESHOLD = .01;
        assertTrue(error, Math.abs(exp - avg) < THRESHOLD);
    }
    
}