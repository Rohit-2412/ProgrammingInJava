// 10-07-2022 19:07 July
/*
Find maximum meetings in one room

Difficulty Level : Medium
Last Updated : 23 Jun, 2022
There is one meeting room in a firm. There are N meetings in the form of (S[i], F[i]) where S[i] is the start time of
 meeting i and F[i] is the finish time of meeting i. The task is to find the maximum number of meetings that can be
 accommodated in the meeting room. Print all meeting numbers

Examples:

Input : s[] = {1, 3, 0, 5, 8, 5}, f[] = {2, 4, 6, 7, 9, 9}
Output : 1 2 4 5
First meeting [1, 2]
Second meeting [3, 4]
Fourth meeting [5, 7]
Fifth meeting [8, 9]

Input : s[] = {75250, 50074, 43659, 8931, 11273, 27545, 50879, 77924},
f[] = {112960, 114515, 81825, 93424, 54316, 35533, 73383, 160252 }
Output : 6 7 1
 */

package DSA.Greedy;

import java.util.ArrayList;
import java.util.Comparator;

public class MaxMeeting {
    public static void main(String[] args) {
        // Starting time
        int s[] = {1, 3, 0, 5, 8, 5};
        
        // Finish time
        int f[] = {2, 4, 6, 7, 9, 9};
        
        // Defining an arraylist of meet type
        ArrayList<Meeting> meet = new ArrayList<>();
        for (int i = 0; i < s.length; i++)
            
            // Creating object of meeting
            // and adding in the list
            meet.add(new Meeting(s[i], f[i], i));
        
        // Function call
        maxMeeting(meet);
    }
    
    static void maxMeeting(ArrayList<Meeting> list) {
        // sorting according to finish time
        list.sort(Comparator.comparingInt(a -> a.end));
        
        int meet = 1;
        int last_time = list.get(0).end;
        
        for (int i = 1; i < list.size(); i++) {
            Meeting m = list.get(i);
            if (m.start < last_time) {
                meet++;
                last_time = m.end;
            }
        }
        
        System.out.println(meet);
    }
}

class Meeting {
    int start;
    int end;
    int pos;
    
    Meeting(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}