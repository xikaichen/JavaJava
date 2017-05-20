public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (t.length() == 0) {
            if (s.length() == 0) {
                return true;
            }
            return false;
        }
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            start = findChar(s.charAt(i), t, start); // from the first time the char shows
            if (start == -1) {
                return false;
            }
        }
        return true;
    }
    
    private int findChar(char c, String s, int start) {
        char[] chars = s.toCharArray();
        for (int i = start; i < chars.length; i++) {
            if (c == chars[i]) {
                return i + 1;
            }
        }
        return -1;
    }
}