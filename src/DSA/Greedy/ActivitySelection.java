//05-07-2022 13:04 July

/*
N meetings in one room

There is one meeting room in a firm. There are N meetings in the form of (start[i], end[i]) where start[i] is start
time of meeting i and end[i] is finish time of meeting i.
What is the maximum number of meetings that can be accommodated in the meeting room when only one meeting can be held
 in the meeting room at a particular time?

Note: Start time of one chosen meeting can't be equal to the end time of the other chosen meeting.


Example 1:

Input:
N = 6
start[] = {1,3,0,5,8,5}
end[] =  {2,4,6,7,9,9}
Output:
4
Explanation:
Maximum four meetings can be held with
given start and end timings.
The meetings are - (1, 2),(3, 4), (5,7) and (8,9)
Example 2:

Input:
N = 3
start[] = {10, 12, 20}
end[] = {20, 25, 30}
Output:
1
Explanation:
Only one meeting can be held
with given start and end timings.
 */

package DSA.Greedy;

import java.util.ArrayList;
import java.util.Comparator;

public class ActivitySelection {
    public static void main(String[] args) {
        int[] start = new int[] {1, 3, 0, 5, 8, 5};
        int[] end = new int[] {2, 4, 6, 7, 9, 9};
        System.out.println(maxMeetings(start, end, start.length));
    }
    
    static int maxMeetings(int[] start, int[] end, int n) {
        ArrayList<int[]> list = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < n; i++) {
            list.add(new int[] {start[i], end[i]});
        }
        
        list.sort(Comparator.comparingInt(o -> o[1]));
        int j = 0;
        for (int i = 1; i < n; i++) {
            int[] curr = list.get(i);
            int[] prev = list.get(j);
            if (curr[0] > prev[1]) {
                count++;
                j = i;
            }
        }
        
        return count;
    }
}
