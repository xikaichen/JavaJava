// MAX_VALUE, MIN_VALUE, negative number is not palindrome

public class Solution {
    public boolean isPalindrome(int x) {
        if ( x < 0 || x == Integer.MAX_VALUE || x == Integer.MIN_VALUE) {
            return false;
        }
        int temp = x;
        int rev = 0;
        while (x != 0) {
            int last = x % 10;
            rev = rev * 10 + last;
            x = x / 10;
        }
        return (temp == rev);
    }
}

