// 05-07-2022 13:31 July

package DSA.Greedy;

import java.util.Arrays;

public class JobSequencing {
    public static void main(String[] args) {
        Job[] arr = new Job[4];
        arr[0] = new Job(1, 2, 100);
        arr[1] = new Job(2, 1, 19);
        arr[2] = new Job(3, 2, 27);
        arr[3] = new Job(4, 1, 15);
        System.out.println(Arrays.toString(JobScheduling(arr, arr.length)));
        
    }
    
    static int[] JobScheduling(Job arr[], int n) {
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);
        
        // getting max deadline
        boolean seen = false;
        int best = 0;
        for (int i1 = 0; i1 < n; i1++) {
            int deadline = arr[i1].deadline;
            if (deadline >= 0) {
                if (!seen || deadline > best) {
                    seen = true;
                    best = deadline;
                }
            }
        }
        int maximum = seen ? best : 0;
        
        int[] res = new int[maximum + 1];
        Arrays.fill(res, -1);
        res[0] = 0;
        
        int jobs = 0;
        int jobProfit = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = arr[i].deadline; j >= 0; j--) {
                // empty space
                if (res[j] == -1) {
                    res[j] = i;
                    jobs++;
                    jobProfit += arr[i].profit;
                    break;
                }
            }
        }
        return new int[] {jobs, jobProfit};
    }
}

class Job {
    int id, profit, deadline;
    
    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
    
    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", profit=" + profit +
                ", deadline=" + deadline +
                "}\t";
    }
}
