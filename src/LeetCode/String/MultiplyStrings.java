package LeetCode.String;

/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also
represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class MultiplyStrings {
    public String multiply(String s1, String s2) {
        int[] ans = new int[s1.length() + s2.length() + 1];
        StringBuilder str1 = new StringBuilder(s1);
        StringBuilder str2 = new StringBuilder(s2);
        str1.reverse();
        str2.reverse();
        int val = 0;
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                val = (str1.charAt(i) - '0') * (str2.charAt(j) - '0');
                ans[i + j] += val;
                ans[i + j + 1] += (ans[i + j] / 10);
                ans[i + j] = ans[i + j] % 10;
            }
        }
        StringBuilder result = new StringBuilder();
        boolean add = false;
        for (int number : ans) {
            if (!add && number > 0) {
                add = true;
            }
            if (add) {
                result.append(number);
            }
        }
        return add ? result.toString() : "0";
    }
}
