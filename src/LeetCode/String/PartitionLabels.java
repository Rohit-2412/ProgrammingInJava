package LeetCode.String;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> partitionLengths = new ArrayList<>();
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            // storing last index of each character
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        
        int i = 0;
        while (i < s.length()) {
            int end = lastIndex[s.charAt(i) - 'a']; // getting end idx of first character
            int j = i ; // we will check from next idx for other char's last idx and take the maximum of both
            while (j != end)
                end = Math.max(end, lastIndex[s.charAt(j++) - 'a']);
            partitionLengths.add(j - i + 1);
            i = j + 1;
        }
        return partitionLengths;
    }
}
