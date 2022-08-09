package LeetCode.Stack;

public class MakeValidParantheses {
    public String minRemoveToMakeValid(String s) {
        StringBuilder ans = new StringBuilder();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            }
            else if (c == ')') {
                if (count == 0) {
                    continue;
                }
                count--;
            }
            ans.append(c);
        }
        // now we may have some extra opening braces '('
        StringBuilder result = new StringBuilder();
        for (int i = ans.length() - 1; i >= 0; i--) {
            if (ans.charAt(i) == '(' && count-- > 0) continue;
            result.append(ans.charAt(i));
        }
        return result.reverse().toString();
    }
}
