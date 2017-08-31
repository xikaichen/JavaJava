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


// O(n ^ 2) solution
class Solution {
    private int index, maxLen;
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            isPalindrome(s, i, i);
            isPalindrome(s, i, i + 1);
        }
        return s.substring(index, index + maxLen);
    }
    
    private void isPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (maxLen < right - left - 1) {
            index = left + 1;
            maxLen = right -left - 1;
        }
    }
}

