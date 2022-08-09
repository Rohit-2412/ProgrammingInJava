package LeetCode.Array;

public class ArrayProduct {
    
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
//        productExceptSelf(arr);
    }
    
    public static int[] productExceptSelf(int[] nums) {
        
        int size = nums.length;
        int[] result = new int[size];
        
        for (int i = 0; i < size; i++) {
            result[i] = 1;
        }
        
        int prefix = 1;
        for (int i = 0; i < size; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }
//        System.out.println(Arrays.toString(result));
        int postfix = 1;
        for (int i = size - 1; i >= 0; i--) {
            result[i] *= postfix;
            postfix *= nums[i];
        }
//        System.out.println(Arrays.toString(result));
        return result;
    }
}
