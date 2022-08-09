package DSA.String;

public class LongestCommonPrefix {
    
    public static void main(String[] args) {
        String[] strings = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strings));
    }
    
    public static String longestCommonPrefix(String[] strings) {
        String s = strings[0];
        
        for (int i = 1; i < strings.length; i++) {
            int ans = 0;
            for (int j = 0; j < s.length(); j++) {
                if (j < strings[i].length() && s.charAt(j) == strings[i].charAt(j)) {
                    ans++;
                }
                else {
                    s = s.substring(0, ans);
                    break;
                }
            }
        }
        return s;
    }
}
