public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int maxLength = 1;
        int index = 0;
        for (int i = 1; i < s.length(); i++) {
            if (isPalindrome(s.substring(i - maxLength, i + 1))) {
                index = i - maxLength;
                maxLength += 1;
            } else if (i - maxLength - 1 >= 0 && 
                isPalindrome(s.substring(i - maxLength - 1, i + 1))) {
                index = i - maxLength - 1;
                maxLength += 2;
            }
        }
        return s.substring(index, index + maxLength);
    }
    
    private boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            if (chars[i] != chars[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

