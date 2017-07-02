//two useful function
//Character.isLetterOrDigit(char c)
//Character.toLowerCase(char c)
//there might be digits in the case, so use isLetterOrDigit instead of isLetter
public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            while(left < right && !Character.isLetterOrDigit(chars[left])) {
                left++;
            }
            while(left < right && !Character.isLetterOrDigit(chars[right])) {
                right--;
            }
            if (left < right && Character.toLowerCase(chars[left]) != Character.toLowerCase(chars[right])) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}