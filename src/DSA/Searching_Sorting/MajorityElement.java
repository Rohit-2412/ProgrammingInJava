package DSA.Searching_Sorting;

public class MajorityElement {
    
    static int majorityElement(int[] arr, int size) {
        int count = 1; int res = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            int num = arr[i]; if (count == 0) res = num;
            
            if (num == res) {
                count++;
            }
            else {
                count--;
            }
        }
        
        int temp = 0;
        
        for (int i = 0; i < size; i++) {
            if (arr[i] == res) {
                temp++;
            }
        }
        
        if (temp > size / 2) {
            return res;
        }
        else {
            return -1;
        }
    }
    
}
