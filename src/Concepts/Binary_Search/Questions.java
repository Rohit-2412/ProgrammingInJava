package Concepts.Binary_Search;

public class Questions {
    public static void main(String[] args) {
//        question 1
//        ceiling of a number (to find a number greater or equal to target)
//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 9, 12, 13, 15, 17};
//        int target = 80;
/*
        System.out.println("The number greater than or equal to " + target + " is : " + ceiling(arr, target));
        System.out.println(Arrays.toString(arr));
        
        question 2
        floor of a number (the greatest number smaller or equal to target)
        same code just in this case return arr[end]
*/
//      target = -1;
//      System.out.println("The number less than or equal to " + target + " is : " + floor(arr, target));
//      System.out.println(Arrays.toString(arr));
    
/*
//      question 3
        char[] letters = {'a', 'b', 'd', 'f', 'g'};
        char targetChar = 'd';
        System.out.println(smallestLetter(letters, targetChar));
*/

/*
        question 4
        Find First and Last Position of Element in Sorted Array
        [5, 7, 7, 7, 7, 7, 8, 8, 8, 10]
        int[] nums = {5, 7, 7, 7, 7, 8, 8, 8, 10};
        int target = 57;
        int[] ans = {-1, -1};
        int start = search(nums, target, true);
        int end = search(nums, target, false);
        ans[0] = start;
        ans[1] = end;
        
        
        question 5
        search for an element in an infinite sorted array means you don't know the length of array and neither you
        can use the length function
        now find the index of target element
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 19, 21};
        int key = 14;
        System.out.println(searchInInfiniteArray(numbers, key));
        
        
        question 6
        search for an element in a sorted and rotated array
        approach :
        first we will find the pivot element in the array
        an element which is greater than its left and right neighbour or max element in whole array
        int[] arr = {6, 7, 8, 9, 10, 0, 1, 2, 3, 4};
        System.out.println(rotatedBinarySearch(arr, 10));
        System.out.println(pivotIndex(arr));
*/

//        question 7
//        find an element in rotated and sorted array with containing duplicates
//        int[] arr = {5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 9, 1, 1, 1, 1, 2, 2, 3, 4, 4, 4, 5};
//        int target = 9;
//        System.out.println(searchInRotatedSortedArrayWithDuplicates(arr));

//        question 8
//        number of rotations in a rotated array
//        it is equal to pivot index + 1
//        int[] nums = {4, 5, 6, 7, 1, 2, 3};
//        System.out.println(rotationCount(nums));

//        question 9
//        maximum split array the largest sum
//        we have to divide an array in m parts and find the minimum of the maximum sum of all combinations
        int[] arr = {1, 2, 5, 10, 5};
        System.out.println(maxSplitArraySum(arr, 2));
    }
    
    // q1
    static int ceiling(int[] arr, int target) {
        if (target > arr[arr.length - 1]) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            }
            else if (arr[mid] < target) {
                start = mid + 1;
            }
            else if (arr[mid] == target) {
                return arr[mid];
            }
        }
        return arr[start];
    }
    
    // q2
    static int floor(int[] arr, int target) {
        if (target < arr[0]) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            }
            else if (arr[mid] < target) {
                start = mid + 1;
            }
            else if (arr[mid] == target) {
                return arr[mid];
            }
        }
        return arr[end];
    }
    
    // q3
    static char smallestLetter(char[] letters, char target) {
        if (target >= letters[letters.length - 1]) {
            return letters[0];
        }
        int start = 0;
        int end = letters.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (letters[mid] > target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        // handling index out of bound case or {wrap around}
        return letters[start % (letters.length)];
        
    }
    
    // q4
    static int search(int[] nums, int target, boolean findStartIdx) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1; // initially we assume no answer possible
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            }
            else if (nums[mid] < target) {
                start = mid + 1;
            }
            else {
                ans = mid;
                if (findStartIdx) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
    
    // q5
    static int searchInInfiniteArray(int[] arr, int target) {
//        we will start with smallest box of length 2
        int start = 0;
        int end = 1;
//      till the time we found correct box length we will be increasing the box size
        while (target > arr[end]) {
            int temp = end + 1; // new start index , new start will start from the next end of older end's index
            // (newStart = oldEnd + 1)
            
            // newEnd = oldEnd + (size of prev box) * 2
            end = end + (start - end + 1) * 2;
            start = temp; // since end's value is being changed to we will store it in some temp variable
        }
        // now we have found our box length now we will apply binary search in this box length
        return binarySearch(arr, start, end, target);
    }
    
    // method for binary search for infinite array
    static int binarySearch(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target > arr[mid]) {
                start = mid + 1;
            }
            else if (target < arr[mid]) {
                end = mid - 1;
            }
            else if (target == arr[mid]) {
                return mid;
            }
        }
        return -1;
    }
    
    // q6
    static int rotatedBinarySearch(int[] arr, int target) {
        int pivot = pivotIndex(arr);
        
        //  first we will apply the BS in first sorted part
        //  0 to  pivot idx
        int ans = binarySearch(arr, 0, pivot, target);
        
        if (ans == -1) {
            return binarySearch(arr, pivot + 1, arr.length - 1, target);
        }
        return ans;
    }
    
    // method for finding the pivot index in mountain array or rotated and sorted array
    static int pivotIndex(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            }
//            else (arr[mid] < arr[mid + 1])
            else {
                start = mid + 1;
            }
        }
        return start; // or end (both are having the same value)
    }
    
    // q7
    static int searchInRotatedSortedArrayWithDuplicates(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases over here
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            else if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            // if element at middle, start and end pos is equal then we will move by one index to skip the duplicates
            else if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                // what if  start is our answer,
                // so we will check to assure that we are not skipping our ans
                if (arr[start] > arr[start + 1]) {
                    return start + 1;
                }
                // if condition is being failed then we will skip it
                start++;
                
                // what if end is our answer,
                // so we will check to assure that we are not skipping our ans
                if (arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;
            }
            // left side is sorted so will look in right sub-array for pivot element
            else if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return -1;
    }
    
    // q8
    static int rotationCount(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            }
//            else (arr[mid] < arr[mid + 1])
            else {
                start = mid + 1;
            }
        }
        return start + 1; // or end (both are having the same value)
    }
    
    // q9
    static int maxSplitArraySum(int[] arr, int m) {
        int start = 0; // this will store the maximum value of array elements // because this will be our minimum answer
        int end = 0;   // this will store the sum of all elements of array // as this will be our maximum answer
        for (int num : arr) {
            start = Math.max(start, num);
            end += num;
        }
        
        // now we will apply binary search in [start,end] range
        while (start < end) {
            // try for middle as potential answer
            int mid = start + (end - start) / 2;
            
            // calculate how many pieces we need for our current answer
            int sum = 0; // this will store the sum of one sub-array to find number of pieces
            int pieces = 1;
            for (int i : arr) {
                // if current element plus prev sum is greater than required sum then we will increment pieces and
                // make current sum = current num because in next sub-array sum wil be equal to current element
                if (sum + i > mid) {
                    sum = i;
                    pieces++;
                }
                else {
                    sum += i;
                }
            }
            if (pieces > m) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
            
        }
        return start;
    }
}
    
