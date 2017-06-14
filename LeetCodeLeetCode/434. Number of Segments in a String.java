public class Solution {
    public int countSegments(String s) {
        s = s.trim();
        if (s == null || s.length() == 0) {
            return 0;
        }
        String[] strs = s.split(" +");
        return strs.length;
    }
}