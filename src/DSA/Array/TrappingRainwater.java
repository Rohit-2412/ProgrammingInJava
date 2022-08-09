package DSA.Array;

public class TrappingRainwater {
    public static void main(String[] args) {
        int[] arr = {7, 4, 0, 19, 0, 15};
        System.out.println(trappingWater(arr, arr.length));
    }
    
    static long trappingWater(int[] arr, int n) {
        long water = 0;
        int l = 0;
        int r = arr.length - 1;
        int leftMax = arr[l];
        int rightMax = arr[r];
        
        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, arr[l]);
                water += leftMax - arr[l];
            }
            else {
                r--;
                rightMax = Math.max(rightMax, arr[r]);
                water += rightMax - arr[r];
            }
        }
        return water;
    }
}
