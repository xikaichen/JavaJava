// initialize the result as strs[0], and then compare to strs[1], strs[2], .... find the common string
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            res = findCommonPrefix(res, strs[i]);
        }
        return res;
    }
    
    private String findCommonPrefix(String s1, String s2) {
        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.substring(0, i);
            }
        }
        if (s1.length() > s2.length()) {
            return s2;
        }
        return s1;
    }
}