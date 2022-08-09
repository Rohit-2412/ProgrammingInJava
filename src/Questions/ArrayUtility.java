package Questions;

public class ArrayUtility {
    /**
     * This averageOfOdd method received an array of integers, then calculate the
     * average of the Odd elements of this array.
     * <p>
     * <strong> You can assume that the array is not empty and contains at least 1
     * one element. </strong>
     * </p>
     *
     * <p>
     * For example:
     * </p>
     * <p>
     * <pre>
     *      if inputarray = {3,6}    then    return 3.0
     *      if inputarray = {1,1,1}    then    return 1.0
     *      if inputarray = {2,4,6,3}    then    return  3.0
     *      if inputarray = {11,25,12,50}    then    return 18.0
     * </pre>
     *
     * @param inputarray the input array of integers
     * @return the average of the ODD elements of the input array of integers, the
     * average of type double
     */
    public static double averageOfOdd(int[] inputarray) {
        // implementation of function starts from here//
        
        double totalSum = 0; // variable to store the total sum of all odd numbers
        int numberOfElements = 0; // variable to store the total number of all odd numbers
        
        // iterating over each element in inputarray
        for (int i : inputarray) {
            // if number is not divisible by 2 then it's an odd number
            // adding the current number to total sum and incrementing the count of odd numbers
            if (i % 2 != 0) {
                totalSum += i;
                numberOfElements++;
            }
        }
        
        // if total numbers are 0
        // means we have no odd number in the array
        // then answer would be 0.0
        if (numberOfElements == 0) {
            return 0.0;
        }
        // if total odd numbers are not 0
        // then returning the average
        else {
            return totalSum / numberOfElements;
        }
        // implementation of function ends here //
    }
}
