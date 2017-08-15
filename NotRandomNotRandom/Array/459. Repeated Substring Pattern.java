public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i < s.length(); i++) { // pattern can be length 1, but can't be length equals to s (itself).
            if (s.length() % i == 0) {
                if (checkRepeat(s, i)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean checkRepeat(String s, int factor) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length() / factor; i++) {
            sb.append(s.substring(0, factor));
        }
        return sb.toString().equals(s);
    }
}