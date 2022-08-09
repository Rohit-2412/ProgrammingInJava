package LeetCode.String;

public class AddStrings {
    public static String addStrings(String s1, String s2) {
        StringBuilder ans = new StringBuilder();
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int val1 = (i >= 0) ? s1.charAt(i--) - '0' : 0;
            int val2 = (j >= 0) ? s2.charAt(j--) - '0' : 0;
            int val = val1 + val2 + carry;
            carry = val / 10;
            ans.insert(0, val % 10);
        }
        return ans + "";
    }
}
