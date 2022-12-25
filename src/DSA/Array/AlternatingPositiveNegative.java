package DSA.Array;

import java.util.Arrays;

public class AlternatingPositiveNegative {

  public static void main(String[] args) {
    int[] arr = { -2, -4, -1, 4, 5, 6, 4, 3, 1 };
    System.out.println(Arrays.toString(arr));
    reArrange(arr, arr.length);
    System.out.println(Arrays.toString(arr));
  }

  // Algorithm :
  // first find the idx of wrong element (i.e, an element whose value is -ve and is at odd idx or +ve element at
  // even idx
  // then right rotate the array between these indexes so that negative comes at front and rest of the element
  // shifts by one place

  // function to rotate array to right side by one place between start and end
  public static void rightRotate(int[] arr, int n, int start, int end) {
    // 1 2 3 4 5 6
    // 6 1 2 3 4 5
    int temp = arr[end];
    if (end - start >= 0) System.arraycopy(
      arr,
      start,
      arr,
      start + 1,
      end - start
    );
    //        for (int i = end; i > start; i--) arr[i] = arr[i - 1];
    arr[start] = temp;
  }

  public static void reArrange(int[] arr, int n) {
    int flag = -1;
    for (int i = 0; i < n; i++) {
      // means we have found a negative integer
      if (flag >= 0) {
        if ((arr[i] >= 0 && arr[flag] < 0) || (arr[i] < 0 && arr[flag] >= 0)) {
          //                    System.out.println("flag = " + flag);
          //                    System.out.println(Arrays.toString(arr));
          rightRotate(arr, n, flag, i);
          //                    System.out.println(Arrays.toString(arr));

          if (i - flag >= 2) {
            flag = flag + 2;
          } else {
            flag = -1;
          }
        }
      }

      if (flag == -1) {
        // n & 1 == 1 => odd number
        // n & 1 == 0 => even number

        // on even idx like 0 2 4 6 we should have negative numbers
        // on even idx like 1 3 5 7 9 we should have positive numbers
        if (
          ((arr[i] >= 0 && (i & 0x01) == 0)) || (arr[i] < 0 && (i & 0x01) == 1)
        ) {
          flag = i;
        }
      }
    }
  }
}
