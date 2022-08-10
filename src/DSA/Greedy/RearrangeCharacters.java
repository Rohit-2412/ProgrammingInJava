// 10-08-2022 18:52 August
/*
Rearrange characters
MediumAccuracy: 49.75%Submissions: 15018Points: 4
Lamp
This problem is part of GFG SDE Sheet. Click here to view more.

Given a string S with repeated characters. The task is to rearrange characters in a string such that no two adjacent
characters are the same.
Note: The string has only lowercase English alphabets and it can have multiple solutions. Return any one of them.

Example 1:

Input : str = "geeksforgeeks"
Output: 1
Explanation: All the repeated characters of the
given string can be rearranged so that no
adjacent characters in the string is equal.
Any correct rearrangement will show a output
of 1.
Example 2:

Input : str = "bbbbb"
Output: 0
Explanation: Repeated characters in the string
cannot be rearranged such that there should not
be any adjacent repeated character.
 */

package DSA.Greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeCharacters {
    
    public static void main(String[] args) {
        System.out.println(rearrangeCharacters("geeksforgeeks"));
    }
    
    static String rearrangeCharacters(String str) {
        PriorityQueue<Pair> heap = new PriorityQueue<>((o1, o2) -> o2.freq - o1.freq);
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            heap.add(new Pair(entry.getKey(), entry.getValue()));
        }
        
        StringBuilder ans = new StringBuilder();
        while (heap.size() > 1) {
            Pair p = heap.poll();
            Pair q = heap.poll();
            ans.append(p.character);
            ans.append(q.character);
            
            if (p.freq - 1 >= 1) {
                heap.add(new Pair(p.character, p.freq - 1));
            }
            if (q.freq - 1 >= 1) {
                heap.add(new Pair(q.character, q.freq - 1));
            }
        }
        
        if (heap.size() == 1) {
            if (heap.peek().freq > 1) {
                return "-1";
            }
            else {
                ans.append(heap.peek().character);
            }
        }
//        System.out.println(str.length());
//        System.out.println(ans.length());
        return ans.toString();
        
    }
    
    static class Pair {
        char character;
        int freq;
        
        public Pair(char character, int freq) {
            this.freq = freq;
            this.character = character;
        }
        
        @Override
        public String toString() {
            return character + ":" + freq;
        }
    }
}