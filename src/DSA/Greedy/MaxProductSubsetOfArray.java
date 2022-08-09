// 10-07-2022 19:36 July

package DSA.Greedy;

public class MaxProductSubsetOfArray {
    public static void main(String[] args) {
        int[] a = {-1, -1, -2, 4, 3};
        System.out.println(maxProduct(a));
    }
    
    static int maxProduct(int[] arr) {
        int numZero = 0;
        int neg = 0;
        int negMax = Integer.MIN_VALUE;
        int product = 1;
        
        for (int i : arr) {
            
            if (i == 0) {
                numZero++;
                continue;
            }
            
            if (i < 0) {
                neg++;
                negMax = Math.max(negMax, i);
            }
            
            product *= i;
        }
        if (numZero == arr.length) return 0;
        
        if (neg % 2 == 1) {
            if (neg == 1 && numZero > 0 && numZero + neg == arr.length) {
                return 0;
            }
            product /= negMax;
        }
        return product;
    }
}
