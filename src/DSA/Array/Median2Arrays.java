package DSA.Array;

public class Median2Arrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 12, 15, 26, 38};
        int[] arr2 = {2, 13, 17, 30, 45};
        System.out.println("Median of the two arrays are");
        System.out.println(median(arr1, arr2));
    }
    
    static double median(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        if (n > m) return median(arr2, arr1);
        int s = 0;
        int e = n;
        
        int final_mid = (n + m + 1) / 2;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            int leftAsize = mid;
            int leftBsize = final_mid - mid;
            
            int leftA = (leftAsize > 0) ? arr1[leftAsize - 1] : Integer.MIN_VALUE;
            
            int leftB = (leftBsize > 0) ? arr2[leftBsize - 1] : Integer.MIN_VALUE;
            
            int rightA = (leftA < n) ? arr1[leftAsize] : Integer.MAX_VALUE;
            
            int rightB = (leftB < m) ? arr2[leftBsize] : Integer.MAX_VALUE;
            
            if (leftA <= rightB && leftB <= rightA) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0;
                }
                else {
                    return Math.max(leftA, leftB);
                }
            }
            else if (leftA > leftB) {
                e = mid - 1;
            }
            else {
                s = mid + 1;
            }
        }
        
        return 0;
        
    }
    
}
