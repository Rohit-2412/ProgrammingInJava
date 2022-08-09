package DSA.Linked_List;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
First non-repeating character in a stream
        Medium Accuracy: 51.34% Submissions: 43442 Points: 4
        Given an input stream of A of n characters consisting only of lower case alphabets. The task is to find the
        first non repeating character, each time a character is inserted to the stream. If there is no such character
         then append '#' to the answer.
        
        
        Example 1:
        
        Input: A = "aabc"
        Output: "a#bb"
        Explanation: For every character first non
        repeating character is as follow-
        "a" - first non-repeating character is 'a'
        "aa" - no non-repeating character so '#'
        "aab" - first non-repeating character is 'b'
        "aabc" - first non-repeating character is 'b'
        Example 2:
        
        Input: A = "zz"
        Output: "z#"
        Explanation: For every character first non
        repeating character is as follow-
        "z" - first non-repeating character is 'z'
        "zz" - no non-repeating character so '#'
*/
public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println(FirstNonRepeating("aabccd"));
    }
    
    static String FirstNonRepeating(String str) {
        // Method 1

//        StringBuilder ans = new StringBuilder();
//        List<Character> list = new ArrayList<>();
//        int[] visited = new int[26];
//        Arrays.fill(visited, 0);
//
//        for (char c : str.toCharArray()) {
//            if (visited[c - 'a'] == 0) {
//                list.add(c);
//            }
//            visited[c - 'a']++;
//
//            boolean f = false;
//            for (Character chr : list) {
//                if (visited[chr - 'a'] == 1) {
//                    ans.append(chr);
//                    f = true;
//                    break;
//                }
//            }
//            if (!f) {
//                ans.append("#");
//            }
//        }
//        return ans.toString();
        
        // Method 2
        
        Queue<Character> q = new PriorityQueue<>();
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder ans = new StringBuilder();
        
        for (char c : str.toCharArray()) {
            // adding current element and its frequency to the map
            map.put(c, map.getOrDefault(c, 0) + 1);
            
            // if freq == 1 implies this is the first occurrence
            if (map.get(c) == 1) {
                // adding it to the queue
                q.add(c);
            }
            
            // keep popping out elements until q is not empty and
            // freq of the first occurred character is greater than 1
            while (q.size()!=0 && map.get(q.peek()) > 1) {
                q.poll();
            }
            
            // if queue becomes empty
            // this means that there is no non-repeating character
            if (q.size()==0) {
                ans.append("#");
            }
            // there is a non repeating character, add it to the answer
            else {
                ans.append(q.peek());
            }
        }
        return ans.toString();
    }
}