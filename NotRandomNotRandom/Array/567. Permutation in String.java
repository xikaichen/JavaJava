// rolling window的思想
public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[26];
        if (s1.length() > s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if (allZero(count)) {
            return true;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - s1.length()) - 'a']++;
            if (allZero(count)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean allZero(int[] count) {
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}