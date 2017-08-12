public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (count == 0 && s.charAt(i) == ' ') { // if there are some blank in the tail
                continue;
            }
            if (s.charAt(i) != ' ') {
                count++;
            } else {
                return count;
            }
        }
        return count;
    }
}