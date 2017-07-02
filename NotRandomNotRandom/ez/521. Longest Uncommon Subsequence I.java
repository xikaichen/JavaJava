public class Solution {
    public int findLUSlength(String a, String b) {
        if (a == null || b == null) {
            return -1;
        }
        int lengthA = a.length();
        int lengthB = b.length();
        int minLength = Math.min(lengthA, lengthB);
        if (lengthA != lengthB) {
            return Math.max(lengthA, lengthB);
        }
        for (int i = minLength - 1; i > 0; i--) {
            if (a.charAt(i) != b.charAt(i)) {
                return i + 1;
            }
        } 
        return -1;
    }
}