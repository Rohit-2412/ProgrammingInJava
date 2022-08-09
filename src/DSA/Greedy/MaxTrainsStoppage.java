// 07-07-2022 20:24 July

package DSA.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MaxTrainsStoppage {
    static int n = 3; // number of platforms
    static int m = 6; // number of trains
    
    public static void main(String[] args) {
        // arrival  departure   platform
        int[][] arr = new int[m][3];
        arr[0] = new int[] {1000, 1030, 1};
        arr[1] = new int[] {1010, 1030, 1};
        arr[2] = new int[] {1000, 1020, 2};
        arr[3] = new int[] {1030, 1230, 2};
        arr[4] = new int[] {1200, 1230, 2};
        arr[5] = new int[] {900, 1005, 3};
        System.out.println((maxStop(arr)));
    }
    
    static int maxStop(int[][] arr) {
        // creating a map to store the arrival and departure time as value at key = platform number
        HashMap<Integer, ArrayList<Pair>> map = new HashMap<>();
        
        // If current platform is empty then add a new array list
        for (int i = 1; i <= n; i++) {
            map.putIfAbsent(i, new ArrayList<>());
        }
        
        // Adding the value as a pair of arrival and departure at key is equals to platform number
        for (int i = 0; i < m; i++) {
            map.get(arr[i][2]).add(new Pair(arr[i][0], arr[i][1]));
        }
        
        // total trains for which stoppage can be provided
        int count = 0;
        
        // checking each entry in map
        for (Map.Entry<Integer, ArrayList<Pair>> entry : map.entrySet()) {
            ArrayList<Pair> pair = entry.getValue(); // getting value
            count += findStoppage(pair);
        }
        return count;
    }
    
    // N meetings in one room
    static int findStoppage(ArrayList<Pair> list) {
        Collections.sort(list); // Sorting the list of arrival and departure time in descending order
        // As per the departure time
        
        int meeting = 1;
        int lastEnd = list.get(0).departure; // current maximum time till which the train has to be stopped
        
        for (int i = 1; i < list.size(); i++) {
            int fStart = list.get(i).arrival; // start of first train in list
            // if the start of the current train is less than the departure of prev train
            if (fStart > lastEnd) {
                meeting++;
                lastEnd = list.get(i).departure; // updating the last end with current train's departure
            }
        }
        return meeting;
    }
    
    static class Pair implements Comparable<Pair> {
        
        int arrival;
        int departure;
        
        public Pair(int arrival, int departure) {
            this.arrival = arrival;
            this.departure = departure;
        }
        
        @Override
        public int compareTo(Pair o) {
            return this.departure - o.departure;
        }
        
    }
}
