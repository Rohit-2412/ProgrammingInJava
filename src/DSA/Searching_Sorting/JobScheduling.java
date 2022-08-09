package DSA.Searching_Sorting;

/*

Weighted Job Scheduling
Difficulty Level : Medium
Last Updated : 23 Mar, 2022
Given N jobs where every job is represented by following three elements of it.

Start Time
Finish Time
Profit or Value Associated (>= 0)
Find the maximum profit subset of jobs such that no two jobs in the subset overlap.

Example:

Input: Number of Jobs n = 4
       Job Details {Start Time, Finish Time, Profit}
       Job 1:  {1, 2, 50}
       Job 2:  {3, 5, 20}
       Job 3:  {6, 19, 100}
       Job 4:  {2, 100, 200}
Output: The maximum profit is 250.
We can get the maximum profit by scheduling jobs 1 and 4.
Note that there is longer schedules possible Jobs 1, 2 and 3
but the profit with this schedule is 20+50+100 which is less than 250.

*/

import java.util.Arrays;
import java.util.Comparator;

/*

Weighted Job Scheduling in O(n Log n) time
Difficulty Level : Hard
Last Updated : 22 Feb, 2022
Given N jobs where every job is represented by following three elements of it.

Start Time
Finish Time
Profit or Value Associated
Find the maximum profit subset of jobs such that no two jobs in the subset overlap.
Example:

Input: Number of Jobs n = 4
       Job Details {Start Time, Finish Time, Profit}
       Job 1:  {1, 2, 50}
       Job 2:  {3, 5, 20}
       Job 3:  {6, 19, 100}
       Job 4:  {2, 100, 200}
Output: The maximum profit is 250.
We can get the maximum profit by scheduling jobs 1 and 4.
Note that there is longer schedules possible Jobs 1, 2 and 3
but the profit with this schedule is 20+50+100 which is less than 250.
 
 */

class Job {
    int start, finish, profit;
    
    Job(int start, int finish, int profit) {
        this.start = start;
        this.finish = finish;
        this.profit = profit;
    }
}

public class JobScheduling {
    
/*
    public static void main(String[] args) {
        Job[] arr = new Job[4];
        arr[0] = new Job(3, 10, 20);
        arr[1] = new Job(1, 2, 50);
        arr[2] = new Job(6, 19, 100);
        arr[3] = new Job(2, 100, 200);
        System.out.println(findMaxProfit(arr, arr.length));
    }
    
    // using recursive approach
    static class Job {
        int start, finish, profit;
        
        Job(int start, int finish, int profit) {
            this.start = start;
            this.finish = finish;
            this.profit = profit;
        }
    }
    
    static int nonCollidingJob(Job[] arr, int n) {
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i].finish <= arr[n - 1].start) {
                return i;
            }
        }
        return -1;
    }
    
    static int maxProfit(Job[] arr, int n) {
        if (n == 1) {
            return arr[n - 1].profit;
        }
        
        // considering the previous job's profit
        int inclusiveProfit = arr[n - 1].profit;
        // getting index of next non colliding job
        // so that we can add its profit to our current set
        int num = nonCollidingJob(arr, n);
        // if its present
        if (num != -1) {
            // then look for next such possibilities
            inclusiveProfit += maxProfit(arr, num + 1);
        }
        // if we don't pick up the current job then
        // shrinking size of array
        int excludedProfit = maxProfit(arr, n - 1);
        
        // returning maximum of both possibilities
        return Math.max(inclusiveProfit, excludedProfit);
    }
    
    static int findMaxProfit(Job[] arr, int n) {
        Arrays.sort(arr, new Comparator<Job>() {
            public int compare(Job j1, Job j2) {
                return j1.finish - j2.finish;
            }
        });
        return maxProfit(arr, n);
    }
*/
    
    // in N log N time
    
    static public int binarySearch(Job[] arr, int idx) {
        int low = 0, high = idx - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (arr[mid].finish <= arr[idx].start) {
                if (arr[mid + 1].finish <= arr[idx].start) {
                    low = mid + 1;
                }
                else {
                    return mid;
                }
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
    
    
    static public int schedule(Job[] arr) {
        Arrays.sort(arr, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return Integer.compare(o1.finish, o2.finish);
            }
        });
        
        int n = arr.length;
        int[] table = new int[n];
        table[0] = arr[0].profit;
        
        for (int i = 1; i < n; i++) {
            
            int inclusiveProfit = arr[i].profit;
            int l = binarySearch(arr, i);
            
            if (l != -1) {
                inclusiveProfit += table[l];
            }
            
            table[i] = Math.max(inclusiveProfit, table[i - 1]);
        }
        return table[n - 1];
    }
    
    public static void main(String[] args) {
        Job[] arr = {new Job(1, 2, 50), new Job(3, 5, 20), new Job(6, 19, 100), new Job(2, 100, 200)};
        
        System.out.println("Optimal profit : " + schedule(arr));
    }
}